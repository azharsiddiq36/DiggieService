package com.example.diggieservice.feature.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.diggieservice.MainActivity
import com.example.diggieservice.R
import com.example.diggieservice.feature.login.LoginActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            //start main activity
            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            //finish this activity
            finish()
        },4000)
    }
}