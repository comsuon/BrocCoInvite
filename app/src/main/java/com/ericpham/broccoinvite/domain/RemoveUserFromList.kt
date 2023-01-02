package com.ericpham.broccoinvite.domain

import com.ericpham.broccoinvite.data.InviteRepo
import com.ericpham.broccoinvite.data.po.User
import com.ericpham.broccoinvite.presentation.di.SharedPreferenceQualifier
import javax.inject.Inject

@SharedPreferenceQualifier
class RemoveUserFromList @Inject constructor(private val repo: InviteRepo) {
    suspend fun removeUserFromList(user: User): InviteResult {
        repo.removeUser()
        return InviteResult.Success(user)
    }
}