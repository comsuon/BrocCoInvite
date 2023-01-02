package com.ericpham.broccoinvite.data.remote

import com.ericpham.broccoinvite.data.po.User

interface RemoteDataSource {
    suspend fun fakeAuth(user: User): ApiResponse<String>
}