package com.ericpham.broccoinvite.domain

import com.ericpham.broccoinvite.data.InviteRepo

class InviteUserToList(private val repo: InviteRepo) {
    suspend fun inviteUserToList(user: String): Result<String> {
        return Result.success("")
    }
}