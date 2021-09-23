package com.gr.android.ex_coroutines.UserProfile

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

internal class UserProfileRepository {

    suspend fun fetchUserData(): String {
        return withContext(Dispatchers.IO) {
            delay(7000L)
            "Jose da Silva"
        }
    }
}