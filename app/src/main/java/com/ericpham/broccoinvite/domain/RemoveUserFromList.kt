package com.ericpham.broccoinvite.domain

import com.ericpham.broccoinvite.data.InviteRepo
import com.ericpham.broccoinvite.presentation.di.SharedPreferenceQualifier
import javax.inject.Inject

@SharedPreferenceQualifier
class RemoveUserFromList @Inject constructor(private val repo: InviteRepo) {
    suspend fun removeUserFromList(user: String): Result<String> {
        return Result.success("")
    }
}