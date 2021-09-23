package com.gr.android.ex_coroutines.example

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

internal class CoroutinesViewModel : ViewModel() {

    private val coroutinesRepository = CoroutinesRepository()

    private val _state: MutableLiveData<CoroutinesViewState> = MutableLiveData()
    val state: LiveData<CoroutinesViewState> = _state

//    para executar funcao coroutines
    fun fetchUserName() = viewModelScope.launch {
        _state.value = CoroutinesViewState.Loading
        val username = coroutinesRepository.fetchUserData()
        _state.value = CoroutinesViewState.Success(username = username)
//        println("User name: $username")
    }
}