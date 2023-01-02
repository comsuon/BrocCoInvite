package com.ericpham.broccoinvite.presentation

import android.content.SharedPreferences
import android.os.Parcelable
import android.view.View
import com.ericpham.broccoinvite.presentation.ViewClick.MIN_DELAY_TIME
import com.ericpham.broccoinvite.presentation.ViewClick.hash
import com.ericpham.broccoinvite.presentation.ViewClick.lastClickTime
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException

object ViewClick {
    var MIN_DELAY_TIME: Long = 600
    var lastClickTime: Long = 0
    var hash: Int = 0
}

fun View.setDebounceClick(block: () -> Unit) {
    this.setOnClickListener {
        if (this.hashCode() != hash) {
            hash = this.hashCode()
            lastClickTime = System.currentTimeMillis()
            block()
        } else {
            val currentTime = System.currentTimeMillis()
            if (currentTime - lastClickTime > MIN_DELAY_TIME) {
                lastClickTime = currentTime
                block()
            }
        }
    }
}

