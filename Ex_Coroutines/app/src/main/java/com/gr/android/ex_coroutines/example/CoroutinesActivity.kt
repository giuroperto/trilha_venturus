package com.gr.android.ex_coroutines.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.gr.android.ex_coroutines.R

internal class CoroutinesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_coroutines)
        val viewModel = ViewModelProvider(this).get(CoroutinesViewModel::class.java)

        val txtView = findViewById<TextView>(R.id.textView_profile2)

        viewModel.fetchUserName()
        viewModel.state.observe(this, {
            state ->
            when (state) {
                CoroutinesViewState.Loading -> txtView.text = "Loading..."
                is CoroutinesViewState.Success -> txtView.text = "User is ${state.username}"
            }
        })
    }
}