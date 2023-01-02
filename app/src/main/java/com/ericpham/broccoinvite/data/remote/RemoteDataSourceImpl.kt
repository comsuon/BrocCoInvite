package com.ericpham.broccoinvite.data.remote

import com.ericpham.broccoinvite.data.po.User
import com.google.gson.Gson
import okhttp3.RequestBody
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val networkService: NetworkService) :
    RemoteDataSource {

    override suspend fun fakeAuth(user: User): ApiResponse<String> {
        return safeApiCall {
            networkService.fakeAuth(user)
        }
    }
}