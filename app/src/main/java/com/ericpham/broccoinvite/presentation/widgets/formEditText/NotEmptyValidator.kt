package com.ericpham.broccoinvite.presentation.widgets.formEditText

import android.widget.EditText

class NotEmptyValidator(message: String?) : Validator(message) {

    override fun isValid(editText: EditText): Boolean {
        return editText.text.toString().isBlank().not()
    }
}