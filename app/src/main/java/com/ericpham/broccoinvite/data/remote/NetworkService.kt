package com.ericpham.broccoinvite.data.remote

import retrofit2.http.POST

interface NetworkService {
    @POST("/fakeAuth")
    suspend fun fakeAuth(name: String, email: String): Result<Int>
}