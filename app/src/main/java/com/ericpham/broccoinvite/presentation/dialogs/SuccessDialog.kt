package com.ericpham.broccoinvite.presentation.dialogs

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatDialog
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.ericpham.broccoinvite.R
import com.ericpham.broccoinvite.databinding.LayoutSuccessDialogBinding
import com.ericpham.broccoinvite.presentation.setDebounceClick


class SuccessDialog(
    context: Context,
    private val msg: String = "",
    private val okClickListener: View.OnClickListener? = null
) :
    AppCompatDialog(context) {

    private lateinit var viewBinding: LayoutSuccessDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        var params = window?.attributes
        params?.width = ConstraintLayout.LayoutParams.WRAP_CONTENT
        params?.height = ConstraintLayout.LayoutParams.WRAP_CONTENT

        viewBinding = LayoutSuccessDialogBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        setUpViews()
    }

    private fun setUpViews() {
        Glide.with(context).load(R.drawable.check_circle).into(viewBinding.ivSuccess)
        viewBinding.tvDialogMsg.text = msg
        viewBinding.btnCancel.setDebounceClick {
            okClickListener?.onClick(viewBinding.btnCancel)
            dismiss()
        }
    }

}