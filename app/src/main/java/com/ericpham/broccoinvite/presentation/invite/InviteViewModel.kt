package com.ericpham.broccoinvite.presentation.invite

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ericpham.broccoinvite.data.po.User
import com.ericpham.broccoinvite.domain.InviteResult
import com.ericpham.broccoinvite.domain.InviteUserToList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class InviteViewModel @Inject constructor(
    private val inviteUserUseCase: InviteUserToList
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
            delay(1000)
            val result = inviteUserUseCase.inviteUserToList(user)
            withContext(Dispatchers.Main) {
                _resultLiveData.postValue(result)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        coroutineContext.cancel()
    }
}

