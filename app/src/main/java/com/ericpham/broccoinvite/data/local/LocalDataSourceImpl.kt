package com.ericpham.broccoinvite.data.local

import com.ericpham.broccoinvite.data.po.User
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val persistentManager: PersistentManager) :
    LocalDataSource {
    private val USER_PREF_KEY = "USER_PREF_KEY"
    override fun storeInvitedUser(user: User) {
        persistentManager.putUser(USER_PREF_KEY, user)
    }

    override fun getInvitedUser(): User? {
        return persistentManager.getUser(USER_PREF_KEY)
    }

    override fun removeRequest() {
        persistentManager.deleteKey(USER_PREF_KEY)
    }
}