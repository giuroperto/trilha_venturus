package com.gr.android.trilhaventurus

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class SecondFragment : Fragment(R.layout.fragment_second) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val text = view.findViewById<TextView>(R.id.txtText)
        val backButton = view.findViewById<Button>(R.id.btnFragment2)

        text.text = arguments?.getString("key")

        backButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }
}