package com.ericpham.broccoinvite.data.local

interface PersistentManager {
    fun putString(key: String, value: String)
    fun getString(key: String): String
}