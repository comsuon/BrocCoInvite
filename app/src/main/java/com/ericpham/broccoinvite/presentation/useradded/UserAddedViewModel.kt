package com.ericpham.broccoinvite.presentation.useradded

import androidx.lifecycle.ViewModel
import com.ericpham.broccoinvite.data.InviteRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserAddedViewModel @Inject constructor(private val inviteRepo: InviteRepo) : ViewModel() {
    fun removeRequest() {
        inviteRepo.removeUser()
    }
}