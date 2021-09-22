package com.gr.android.ex_sharedpref

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getPreferences(Context.MODE_PRIVATE)

        with(sharedPref.edit()) {
            putString("KEY_NAME", "MY NAME")
            putInt("KEY_AGE", 100)
            commit()
        }

        val btn = findViewById<Button>(R.id.btn_update)
        val key1 = findViewById<TextView>(R.id.txt_key1)
        val key2 = findViewById<TextView>(R.id.txt_key2)
        val value1 = findViewById<TextView>(R.id.txt_value1)
        val value2 = findViewById<TextView>(R.id.txt_value2)

        btn.setOnClickListener {
            val preference1 = sharedPref.getString("KEY_NAME", "")
            val preference2 = sharedPref.getInt("KEY_AGE", 120)

            key1.text = "KEY_NAME"
            key2.text = "KEY_AGE"
            value1.text = preference1
            value2.text = preference2.toString()
        }
    }
}