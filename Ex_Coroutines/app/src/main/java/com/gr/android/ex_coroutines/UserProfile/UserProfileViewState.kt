package com.gr.android.ex_coroutines.UserProfile

internal sealed class UserProfileViewState {

    object Loading: UserProfileViewState()

    data class Success(val username: String) : UserProfileViewState()
}