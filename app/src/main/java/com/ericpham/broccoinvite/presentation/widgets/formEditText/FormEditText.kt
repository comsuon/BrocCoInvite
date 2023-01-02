package com.ericpham.broccoinvite.presentation.widgets.formEditText

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.textfield.TextInputLayout

class FormEditText(context: Context, attrs: AttributeSet?) : TextInputLayout(context, attrs) {
    private var mValidator: Validator = Validator()

    fun setValidator(validator: Validator) {
        mValidator = validator
    }

    fun validateField(): Boolean {
        if (editText == null) return true
        if (mValidator.isValid(editText!!).not()) {
            error = mValidator.message
            return false
        }
        error = ""
        return true
    }

}