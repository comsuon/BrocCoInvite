package com.ericpham.broccoinvite.presentation.invite

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ericpham.broccoinvite.data.po.User
import com.ericpham.broccoinvite.data.remote.ApiErrorResponse
import com.ericpham.broccoinvite.data.remote.ApiSuccessResponse
import com.ericpham.broccoinvite.domain.InviteResult
import com.ericpham.broccoinvite.domain.InviteUserToList
import com.ericpham.broccoinvite.domain.RemoteFakeAuthUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class InviteViewModel @Inject constructor(
    private val inviteUserUseCase: InviteUserToList,
    private val fakeAuthUseCase: RemoteFakeAuthUser
) : ViewModel() {

    private val _resultLiveData = MutableLiveData<InviteResult>()

    private val coroutineExceptionHandler by lazy {
        CoroutineExceptionHandler { _, _ ->
            viewModelScope.launch(Dispatchers.Main) {
                _resultLiveData.postValue(InviteResult.Error("Something went wrong, please try again!"))
            }
        }
    }

    private val coroutineContext by lazy {
        SupervisorJob() + Dispatchers.IO + coroutineExceptionHandler
    }

    val resultLiveData = _resultLiveData

    fun signUpUserByNameAndEmail(user: User) {
        _resultLiveData.postValue(InviteResult.Loading)
        viewModelScope.launch(coroutineContext) {
            when (val fakeAuthResult = fakeAuthUseCase.fakeAuth(user)) {
                is ApiSuccessResponse -> {
                    val storeUser = inviteUserUseCase.inviteUserToList(user)
                    withContext(Dispatchers.Main) {
                        _resultLiveData.postValue(storeUser)
                    }
                }
                is ApiErrorResponse -> {
                    withContext(Dispatchers.Main) {
                        _resultLiveData.postValue(InviteResult.Error(fakeAuthResult.errorMessage))
                    }
                }
            }

        }
    }

    override fun onCleared() {
        super.onCleared()
        coroutineContext.cancel()
    }
}

