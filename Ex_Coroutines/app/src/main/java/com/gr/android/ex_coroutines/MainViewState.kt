package com.gr.android.ex_coroutines

sealed class MainViewState {

    object Idle: MainViewState()

    object Loading: MainViewState()

    object Success: MainViewState()

    object Executing: MainViewState()
}