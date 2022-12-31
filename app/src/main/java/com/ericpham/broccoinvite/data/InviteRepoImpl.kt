package com.ericpham.broccoinvite.data

import com.ericpham.broccoinvite.data.local.LocalDataSource
import com.ericpham.broccoinvite.data.remote.RemoteDataSource
import javax.inject.Inject

class InviteRepoImpl @Inject constructor(local: LocalDataSource, remote: RemoteDataSource): InviteRepo {
    override fun addUser() {

    }

    override fun removeUser() {
    }
}