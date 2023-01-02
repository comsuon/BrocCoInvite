package com.ericpham.broccoinvite.data

import com.ericpham.broccoinvite.data.po.User

interface InviteRepo {
    fun addUser(user: User)
    fun removeUser()
    fun getUser(): User?
}