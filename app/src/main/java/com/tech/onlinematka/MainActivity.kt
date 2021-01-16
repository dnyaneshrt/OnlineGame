package com.tech.onlinematka

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import com.tech.onlinematka.ui.AdminPanelActivity

class MainActivity : AppCompatActivity() {
    var btn_sign_in:Button?=null
    var btn_sign_up:Button?=null
    var btn_admin:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        init()
        btn_sign_in?.setOnClickListener {
            var intent=Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
        btn_sign_up?.setOnClickListener {
            var intent=Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
        btn_admin?.setOnClickListener {
            var intent=Intent(this,AdminPanelActivity::class.java)
            startActivity(intent)
        }
    }

    private fun init() {
       btn_sign_in=findViewById(R.id.button_signin)
        btn_sign_up=findViewById(R.id.button_signup)
        btn_admin=findViewById(R.id.button_Admin)
    }


}