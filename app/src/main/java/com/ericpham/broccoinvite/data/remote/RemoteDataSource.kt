package com.ericpham.broccoinvite.data.remote

import javax.inject.Inject

interface RemoteDataSource {
    suspend fun fakeAuth(name: String, email: String): Result<Int>
}