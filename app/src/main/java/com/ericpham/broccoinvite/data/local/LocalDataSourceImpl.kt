package com.ericpham.broccoinvite.data.local

import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(persistentManager: PersistentManager): LocalDataSource {
    override fun storeInvitedUser(name: String, email: String) {

    }
}