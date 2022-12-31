package com.ericpham.broccoinvite.presentation.invite

import androidx.lifecycle.ViewModel
import com.ericpham.broccoinvite.domain.InviteUserToList
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InviteViewModel @Inject constructor(
    private val inviteUserUseCase: InviteUserToList
): ViewModel() {

    fun signUpUserByNameAndEmail(name: String, email: String) {

    }
}