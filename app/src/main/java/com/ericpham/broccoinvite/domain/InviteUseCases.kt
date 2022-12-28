package com.ericpham.broccoinvite.domain

import com.ericpham.broccoinvite.data.InviteRepo

class AddUserToList(private val repo: InviteRepo) {
    suspend fun addUserToList(user: String): Result<String> {
        return Result.success("")
    }
}