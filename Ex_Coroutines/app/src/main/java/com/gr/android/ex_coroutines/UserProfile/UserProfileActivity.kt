package com.gr.android.ex_coroutines.UserProfile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.gr.android.ex_coroutines.R

internal class UserProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_user_profile)
        val viewModel = ViewModelProvider(this).get(UserProfileViewModel::class.java)

        val textView = findViewById<TextView>(R.id.textView_profile)

        viewModel.fetchUserName()
        viewModel.state.observe(this, {
            state ->
            when (state) {
                UserProfileViewState.Loading -> textView.text = "Loading..."
                is UserProfileViewState.Success -> textView.text = "User is ${state.username}"
            }
        })
    }
}