package com.ericpham.broccoinvite.presentation

import androidx.lifecycle.ViewModel
import com.ericpham.broccoinvite.data.po.User
import com.ericpham.broccoinvite.domain.GetUser
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val useCase: GetUser): ViewModel() {
    fun getUser(): User? = useCase.getUser()
}