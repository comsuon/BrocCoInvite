package com.ericpham.broccoinvite.presentation.invite

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ericpham.broccoinvite.R
import com.ericpham.broccoinvite.data.po.User
import com.ericpham.broccoinvite.databinding.FragmentInviteUsersBinding
import com.ericpham.broccoinvite.domain.InviteResult
import com.ericpham.broccoinvite.presentation.BaseFragment
import com.ericpham.broccoinvite.presentation.dialogs.SuccessDialog
import com.ericpham.broccoinvite.presentation.setDebounceClick
import com.ericpham.broccoinvite.presentation.widgets.formEditText.*
import dagger.hilt.android.AndroidEntryPoint

/**
 * A Fragment to help users request access to the App release
 */
@AndroidEntryPoint
class InviteFragment : BaseFragment<FragmentInviteUsersBinding>() {

    private val viewModel: InviteViewModel by viewModels()
    private lateinit var formCollections: Array<FormEditText?>

    private val userName: String
        get() = viewBinding?.formName?.editText?.text?.toString() ?: ""

    private val userEmail: String
        get() = viewBinding?.formEmail?.editText?.text?.toString() ?: ""

    override fun provideViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentInviteUsersBinding = FragmentInviteUsersBinding.inflate(inflater, container, false)

    override fun subscribeLiveData() {
        viewModel.resultLiveData.observe(viewLifecycleOwner) { result ->
            when (result) {
                is InviteResult.Loading -> {
                    showLoadingDialog(getString(R.string.invite_loading_message))
                }
                is InviteResult.Success -> {
                    dismissLoadingDialog()
                    val successDialog = SuccessDialog(
                        requireContext(), getString(R.string.congrats_request_sent_msg)
                    ) {
                        //navigate to success fragment
                        val action =
                            InviteFragmentDirections.actionInviteFragmentToAddedFragment(result.user)
                        findNavController().navigate(action)
                    }.apply {
                        setCancelable(false)
                        show()
                    }

                }
                is InviteResult.Error -> {
                    handleErrorMsg(result.errorMsg)
                    dismissLoadingDialog()
                }
            }

        }
    }

    override fun setupViews() {
        //form validator declaration
        viewBinding?.formName?.setValidator(NameValidator(getString(R.string.validate_name_error_msg)))
        viewBinding?.formEmail?.setValidator(EmailValidator(getString(R.string.validate_email_error_msg)))

        formCollections =
            arrayOf(viewBinding?.formName, viewBinding?.formEmail, viewBinding?.formConfirmEmail)

        //button listener setting
        viewBinding?.btnReset?.setDebounceClick {
            formCollections.forEach { each ->
                each?.editText?.setText("")
            }
        }

        viewBinding?.btnSubscribe?.setDebounceClick {
            //set SameContentValidator as user click request to get content of email form
            viewBinding?.formConfirmEmail?.setValidator(
                AndValidator(
                    message = getString(R.string.validate_confirm_email_error_msg),
                    left = NotEmptyValidator(null),
                    right = SameContentValidator(
                        null,
                        userEmail
                    )
                )
            )
            var isFormValid = true
            formCollections.forEach { isFormValid = it?.validateField() ?: false && isFormValid }
            if (isFormValid) {
                //Call BE to add to invite list
                viewModel.requestAppAccess(User(userName, userEmail))
            } else {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.form_invalid_toast_msg),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }

    override fun initializations() {

    }
}