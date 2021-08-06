package com.gr.android.trilhaventurus_ex3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window.FEATURE_NO_TITLE
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar_custom))
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val countText : TextView = findViewById(R.id.txt_count)
        val addBtn : Button = findViewById(R.id.btn_add)

        count = savedInstanceState?.getString("KEY_STATE")?.toInt() ?: count
        countText.text = count.toString()

        addBtn.setOnClickListener {
            count += 1
            countText.text = count.toString()
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val currentCount = findViewById<TextView>(R.id.txt_count).text.toString()

        outState.putString("KEY_STATE", currentCount)
    }
}