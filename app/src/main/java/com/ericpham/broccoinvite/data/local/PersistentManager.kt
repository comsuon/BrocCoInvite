package com.ericpham.broccoinvite.data.local

import com.ericpham.broccoinvite.data.po.User

interface PersistentManager {
    fun deleteKey(key: String)
    fun putUser(key: String, user: User)
    fun getUser(key: String): User?
}