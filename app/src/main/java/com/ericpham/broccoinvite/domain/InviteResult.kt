package com.ericpham.broccoinvite.domain

import com.ericpham.broccoinvite.data.po.User

sealed class InviteResult {
    object Loading : InviteResult()
    data class Success(val user: User) : InviteResult()
    data class Error(val errorMsg: String) : InviteResult()
}