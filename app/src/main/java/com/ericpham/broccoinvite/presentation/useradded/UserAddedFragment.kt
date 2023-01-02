package com.ericpham.broccoinvite.presentation.useradded

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ericpham.broccoinvite.R
import com.ericpham.broccoinvite.databinding.FragmentUserAddedBinding
import com.ericpham.broccoinvite.presentation.BaseFragment
import com.ericpham.broccoinvite.presentation.setDebounceClick
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * A Fragment to show users that they are already added in to the request list,
 * and provide option to Cancel the requests
 */
@AndroidEntryPoint
class UserAddedFragment : BaseFragment<FragmentUserAddedBinding>() {
    override fun provideViewBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ): FragmentUserAddedBinding = FragmentUserAddedBinding.inflate(inflater, container, false)

    private val viewModel by viewModels<UserAddedViewModel>()

    override fun subscribeLiveData() {

    }

    override fun setupViews() {
        viewBinding?.btnReset?.setDebounceClick {
            viewModel.removeRequest()
            GlobalScope.launch(Dispatchers.Main) {
                delay(1000)
                findNavController().navigate(R.id.action_AddedFragment_to_InviteFragment)
            }
        }
    }

    override fun initializations() {
        val bundle = arguments ?: return

        val args = UserAddedFragmentArgs.fromBundle(bundle)
        val user = args.userBundle
        if (user != null) {
            viewBinding?.nameText?.text = user.name
            viewBinding?.emailText?.text = user.email
        }
    }
}