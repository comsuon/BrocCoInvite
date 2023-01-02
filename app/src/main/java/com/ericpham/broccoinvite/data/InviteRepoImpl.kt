package com.ericpham.broccoinvite.data

import com.ericpham.broccoinvite.data.local.LocalDataSource
import com.ericpham.broccoinvite.data.po.User
import com.ericpham.broccoinvite.data.remote.ApiResponse
import com.ericpham.broccoinvite.data.remote.RemoteDataSource
import javax.inject.Inject

class InviteRepoImpl @Inject constructor(
    private val local: LocalDataSource,
    private val remote: RemoteDataSource
) : InviteRepo {

    override fun addUser(user: User) {
        local.storeInvitedUser(user)
    }

    override fun removeUser() {
        local.removeRequest()
    }

    override fun getUser(): User? {
        return local.getInvitedUser()
    }

    override suspend fun fakeAuth(user: User): ApiResponse<String> {
        return remote.fakeAuth(user)
    }
}