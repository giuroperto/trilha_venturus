package com.gr.android.ex_coroutines.example

internal sealed class CoroutinesViewState {

    object Loading : CoroutinesViewState()

    data class Success(val username: String) : CoroutinesViewState()
}