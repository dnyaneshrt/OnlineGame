package com.tech.onlinematka.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.tech.onlinematka.R

class RechargeActivity : AppCompatActivity() {

    var et_mobile_number: EditText? = null
    var et_amount: EditText? = null
    var btn_submit: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recharge)

        init()

        btn_submit?.setOnClickListener {
            var mobile_number_entered_by_user = et_mobile_number?.text.toString()
            Toast.makeText(this, mobile_number_entered_by_user, Toast.LENGTH_SHORT).show()

        }
    }

    private fun init() {
        et_mobile_number = findViewById(R.id.editTextPhone2)
        et_amount = findViewById(R.id.editTextNumber)
        btn_submit = findViewById(R.id.button_submit)
    }
}