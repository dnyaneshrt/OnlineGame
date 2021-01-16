package com.tech.onlinematka.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.tech.onlinematka.R

class AdminPanelActivity : AppCompatActivity() {
    var btn_recharge: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_panel)

        init()

        btn_recharge?.setOnClickListener {

            var intent= Intent(this,RechargeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun init() {
        btn_recharge=findViewById(R.id.btn_recharge)
    }
}