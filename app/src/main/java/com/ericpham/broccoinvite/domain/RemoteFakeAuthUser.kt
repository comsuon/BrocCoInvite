package com.ericpham.broccoinvite.domain

import com.ericpham.broccoinvite.data.InviteRepo
import com.ericpham.broccoinvite.data.po.User
import com.ericpham.broccoinvite.data.remote.ApiResponse
import javax.inject.Inject

class RemoteFakeAuthUser @Inject constructor(private val repo: InviteRepo) {
    suspend fun fakeAuth(user: User): ApiResponse<String> {
        return repo.fakeAuth(user)
    }
}