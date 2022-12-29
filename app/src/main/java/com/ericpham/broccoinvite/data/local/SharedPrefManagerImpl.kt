package com.ericpham.broccoinvite.data.local

import android.content.SharedPreferences

class SharedPrefManagerImpl(private val sharePref: SharedPreferences) : PersistentManager {

    override fun putString(key: String, value: String) {
        sharePref.edit().putString(key, value)
            .apply()
    }

    override fun getString(key: String): String {
        return sharePref.getString(key, "") ?: ""
    }
}