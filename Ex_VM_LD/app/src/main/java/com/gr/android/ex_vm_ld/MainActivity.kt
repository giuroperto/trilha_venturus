package com.gr.android.ex_vm_ld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        val nameTxt: TextView = findViewById(R.id.text_name)
        val nameEdit: EditText = findViewById(R.id.edt_name)
        val otherInfoTxt: TextView = findViewById(R.id.text_other_info)
        val otherInfoEdt: TextView = findViewById(R.id.edt_other_info)
        val saveBtn: TextView = findViewById(R.id.btn_save)

        viewModel.name.observe(this, {
            name -> nameTxt.text = name
        })

        viewModel.otherInfo.observe(this, {
                info -> otherInfoTxt.text = info
        })

        saveBtn.setOnClickListener {
            val inputName = nameEdit.text.toString()
            val inputOtherInfo = otherInfoEdt.text.toString()

            viewModel.updateOtherInfo(inputOtherInfo)
            viewModel.updateName(inputName)
        }

        nameTxt.setOnClickListener {
            viewModel.updateAgainOtherInfo()
        }
    }
}