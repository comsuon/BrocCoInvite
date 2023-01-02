package com.ericpham.broccoinvite.presentation.widgets.formEditText

import android.widget.EditText

class NameValidator(message: String?) : Validator(message) {

    override fun isValid(editText: EditText): Boolean {
        return editText.text.toString().length >= 3
    }
}