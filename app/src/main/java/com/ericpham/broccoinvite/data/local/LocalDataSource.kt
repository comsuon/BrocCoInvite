package com.ericpham.broccoinvite.data.local

interface LocalDataSource {
    fun storeInvitedUser(name: String, email: String)
}