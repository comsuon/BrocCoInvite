package com.ericpham.broccoinvite.presentation.widgets.formEditText

import android.util.Patterns
import android.widget.EditText

class EmailValidator(message: String?) : Validator(message) {

    override fun isValid(editText: EditText): Boolean {
        val text = editText.text.toString()
        return Patterns.EMAIL_ADDRESS.matcher(text).matches()
    }
}