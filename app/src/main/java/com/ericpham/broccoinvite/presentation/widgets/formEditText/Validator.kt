package com.ericpham.broccoinvite.presentation.widgets.formEditText

import android.widget.EditText

open class Validator(var message: String? = "") {
    open fun isValid(editText: EditText): Boolean {
        return true
    }
}