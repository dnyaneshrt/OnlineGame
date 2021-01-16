package com.tech.onlinematka

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class EnterPinActivity : AppCompatActivity() {
    var btn_submit_pin:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_pin)

        init()

        btn_submit_pin?.setOnClickListener {

        var intent= Intent(this,HomeScreenActivity::class.java)
        startActivity(intent)
        }
    }

    private fun init() {
        btn_submit_pin=findViewById(R.id.button_submit_pin)
    }
}