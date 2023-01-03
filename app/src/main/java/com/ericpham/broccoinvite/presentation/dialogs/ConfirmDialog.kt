package com.ericpham.broccoinvite.presentation.dialogs

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatDialog
import androidx.constraintlayout.widget.ConstraintLayout
import com.ericpham.broccoinvite.databinding.LayoutConfirmDialogBinding
import com.ericpham.broccoinvite.presentation.setDebounceClick


class ConfirmDialog(
    context: Context,
    private val title: String = "",
    private val msg: String = "",
    private val okClickListener: View.OnClickListener? = null
) :
    AppCompatDialog(context) {

    private lateinit var viewBinding: LayoutConfirmDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        var params = window?.attributes
        params?.width = ConstraintLayout.LayoutParams.WRAP_CONTENT
        params?.height = ConstraintLayout.LayoutParams.WRAP_CONTENT
        setCancelable(false)
        viewBinding = LayoutConfirmDialogBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        setUpViews()
    }

    private fun setUpViews() {
        viewBinding.tvDialogTitle.text = title
        viewBinding.tvDialogMsg.text = msg
        viewBinding.btnCancel.setDebounceClick {
            dismiss()
        }
        viewBinding.btnConfirm.setDebounceClick {
            okClickListener?.onClick(viewBinding.btnCancel)
            dismiss()
        }
    }

}