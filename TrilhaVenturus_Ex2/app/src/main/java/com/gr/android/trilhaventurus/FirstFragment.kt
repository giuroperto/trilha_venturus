package com.gr.android.trilhaventurus

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class FirstFragment : Fragment(R.layout.fragment_first) {

    val BUNDLE_KEY = "key"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<Button>(R.id.btnFragment)
        val edtText = view.findViewById<EditText>(R.id.edtText)

        button.setOnClickListener {

            val fragment = SecondFragment()

            parentFragmentManager.beginTransaction()
                .add(R.id.fragment_container_view, fragment)
                .addToBackStack(null)
                .commit()

            val bundle = Bundle().apply {
                putString(BUNDLE_KEY, edtText.text.toString())
            }

            fragment.arguments = bundle
        }
    }
}