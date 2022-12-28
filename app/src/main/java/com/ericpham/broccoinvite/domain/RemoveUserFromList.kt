package com.ericpham.broccoinvite.domain

import com.ericpham.broccoinvite.data.InviteRepo

class RemoveUserFromList(private val repo: InviteRepo){
    suspend fun removeUserFromList(user: String): Result<String> {
        return Result.success("")
    }
}