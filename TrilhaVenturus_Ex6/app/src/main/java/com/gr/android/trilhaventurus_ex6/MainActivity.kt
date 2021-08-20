package com.gr.android.trilhaventurus_ex6

import android.content.Context
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtFirstTime = findViewById<ImageView>(R.id.first_time)
        val txtHelloWorld = findViewById<TextView>(R.id.hello_world)

        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE) ?: return

        var count = sharedPref.getInt("NUMBER_TIMES", 0) + 1

        with (sharedPref.edit()) {
            putInt("NUMBER_TIMES", count)
            commit()
        }

        if (count == 1) {
            txtFirstTime.visibility = View.VISIBLE
            txtHelloWorld.visibility = View.GONE
        } else {
            txtFirstTime.visibility = View.GONE
            txtHelloWorld.visibility = View.VISIBLE
        }
    }
}