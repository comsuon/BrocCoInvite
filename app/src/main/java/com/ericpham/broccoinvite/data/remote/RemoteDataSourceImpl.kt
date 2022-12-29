package com.ericpham.broccoinvite.data.remote

import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val networkService: NetworkService): RemoteDataSource {

    override suspend fun fakeAuth(name: String, email: String): Result<Int> {
        return networkService.fakeAuth(name, email)
    }
}