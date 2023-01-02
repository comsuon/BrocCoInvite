package com.ericpham.broccoinvite.presentation.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.ericpham.broccoinvite.R
import com.ericpham.broccoinvite.databinding.LayoutLoadingDialogBinding

class LoadingDialog(
    private var isOutsideTouchCancellable: Boolean = false,
    private var canCancel: Boolean = true
) : DialogFragment() {

    private lateinit var viewBinding: LayoutLoadingDialogBinding

    private var dialogMessage: String? = null

    companion object {
        const val TAG = "LoadingDialog"
        fun newLoading(
            fragmentManger: FragmentManager,
            message: String? = null,
            isOutsideTouchCancellable: Boolean = false,
            isCancellable: Boolean = true
        ): LoadingDialog {
            val dialogFragment = LoadingDialog(isOutsideTouchCancellable, isCancellable)
            dialogFragment.setMessage(message)
            dialogFragment.show(fragmentManger, TAG)
            return dialogFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = LayoutLoadingDialogBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.btnCancel.isVisible = this.canCancel
        viewBinding.btnCancel.setOnClickListener { dismiss() }
        if (dialogMessage.isNullOrBlank().not()) {
            viewBinding.tvDialogMsg.text = dialogMessage
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_FRAME, R.style.LoadingDialog)
    }

    override fun onStart() {
        super.onStart()
        dialog?.setCanceledOnTouchOutside(isOutsideTouchCancellable)
        dialog?.setCancelable(canCancel)
    }

    fun setMessage(message: String?) {
        if (this::viewBinding.isInitialized && message.isNullOrBlank().not()) {
            viewBinding.tvDialogMsg.text = message
        } else {
            this.dialogMessage = message
        }
    }

    fun dismissDialog() {
        dismissAllowingStateLoss()
    }
}