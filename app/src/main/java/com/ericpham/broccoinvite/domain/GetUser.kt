package com.ericpham.broccoinvite.domain

import com.ericpham.broccoinvite.data.InviteRepo
import com.ericpham.broccoinvite.data.po.User
import com.ericpham.broccoinvite.presentation.di.SharedPreferenceQualifier
import javax.inject.Inject

@SharedPreferenceQualifier
class GetUser @Inject constructor(private val repo: InviteRepo) {
    fun getUser(): User? {
        return repo.getUser()
    }
}