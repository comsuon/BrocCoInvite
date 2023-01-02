package com.ericpham.broccoinvite.data.local

import com.ericpham.broccoinvite.data.po.User

interface LocalDataSource {
    fun storeInvitedUser(user: User)
    fun removeRequest()
    fun getInvitedUser(): User?
}