package com.ericpham.broccoinvite.presentation.widgets.formEditText

import android.widget.EditText

class SameContentValidator(message: String?, private val content: String) : Validator(message) {

    override fun isValid(editText: EditText): Boolean {
        return content == editText.text.toString()
    }
}