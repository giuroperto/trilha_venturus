package com.gr.android.trilhaventurus_ex1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtText: EditText = findViewById(R.id.edtTxt)
        val btn: Button = findViewById(R.id.btn)
        val textFromApp: TextView = findViewById(R.id.txtFromOtherApp)

//        sending data to other apps
        btn.setOnClickListener {
            val sendIntent : Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, edtText.text.toString())
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }

//        receiving data from apps
        if (intent.action == Intent.ACTION_SEND) {
            val textReceived = intent.getStringExtra(Intent.EXTRA_TEXT)
            textFromApp.text = textReceived
        }
    }
}