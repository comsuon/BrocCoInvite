package com.ericpham.broccoinvite.data.remote

import com.ericpham.broccoinvite.data.po.User
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface NetworkService {

    @Headers("Content-Type: application/json")
    @POST("/fakeAuth")
    suspend fun fakeAuth(@Body user: User): Response<String>
}