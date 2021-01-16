package com.tech.onlinematka

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import de.hdodenhof.circleimageview.CircleImageView

class SpashActivity : AppCompatActivity() {
    var image_view: CircleImageView? = null
    var animation: Animation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spash)


        image_view = findViewById(R.id.image_logo)
        animation = AnimationUtils.loadAnimation(applicationContext, R.anim.zoomin)
        image_view?.startAnimation(animation)


        Handler().postDelayed({
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }, 2000)

    }
}