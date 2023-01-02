package com.ericpham.broccoinvite.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.ericpham.broccoinvite.presentation.dialogs.LoadingDialog

abstract class BaseFragment<T : ViewBinding> : Fragment() {

    var viewBinding: T? = null

    private val mLoadingDialog: LoadingDialog by lazy {
        childFragmentManager.findFragmentByTag(LoadingDialog.TAG) as? LoadingDialog
            ?: LoadingDialog()
    }

    abstract fun provideViewBinding(inflater: LayoutInflater, container: ViewGroup?): T

    open fun subscribeLiveData() {}

    open fun setupViews() {}

    open fun initializations() {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = provideViewBinding(inflater, container)
        return requireNotNull(viewBinding).root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeLiveData()
        setupViews()
        initializations()
    }

    open fun showLoadingDialog(message: String? = null) {
        if (isAdded && !mLoadingDialog.isAdded) {
            mLoadingDialog.setMessage(message)
            mLoadingDialog.show(childFragmentManager, LoadingDialog.TAG)
        }
    }

    open fun dismissLoadingDialog() {
        if (isLoadingShowing())
            mLoadingDialog.dismissDialog()
    }

    fun isLoadingShowing() = isAdded && mLoadingDialog.isAdded

    fun handleErrorMsg(errorMsg: String) {
        Toast.makeText(requireContext(), errorMsg, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewBinding = null
    }
}