package com.ericpham.broccoinvite.data.local

import android.content.SharedPreferences
import androidx.core.content.edit
import com.ericpham.broccoinvite.data.po.User

class SharedPrefManagerImpl(private val sharePref: SharedPreferences) : PersistentManager {

    override fun putUser(key: String, value: User) {
        sharePref.edit {
            putParcelable(key, value)
        }
    }

    override fun getUser(key: String): User? {
        return sharePref.getParcelable(key, null)
    }

    override fun deleteKey(key: String) {
        sharePref.edit {
            remove(key)
        }
    }
}