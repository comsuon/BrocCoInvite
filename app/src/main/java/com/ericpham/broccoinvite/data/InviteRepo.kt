package com.ericpham.broccoinvite.data

import com.ericpham.broccoinvite.data.po.User
import com.ericpham.broccoinvite.data.remote.ApiResponse

interface InviteRepo {
    fun addUser(user: User)
    fun removeUser()
    fun getUser(): User?
    suspend fun fakeAuth(user: User): ApiResponse<String>
}