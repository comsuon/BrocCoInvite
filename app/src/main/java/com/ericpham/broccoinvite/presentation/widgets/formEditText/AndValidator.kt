package com.ericpham.broccoinvite.presentation.widgets.formEditText

import android.widget.EditText

class AndValidator(message: String?, private val left: Validator, private val right: Validator): Validator(message) {
    override fun isValid(editText: EditText): Boolean {
        return left.isValid(editText) && right.isValid(editText)
    }
}