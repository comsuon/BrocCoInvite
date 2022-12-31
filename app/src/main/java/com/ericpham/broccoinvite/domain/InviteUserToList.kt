package com.ericpham.broccoinvite.domain

import com.ericpham.broccoinvite.data.InviteRepo
import com.ericpham.broccoinvite.presentation.di.SharedPreferenceQualifier
import javax.inject.Inject

@SharedPreferenceQualifier
class InviteUserToList @Inject constructor(private val repo: InviteRepo) {
    suspend fun inviteUserToList(user: String): Result<String> {
        return Result.success("")
    }
}