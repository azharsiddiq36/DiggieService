package com.example.diggieservice.feature.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.diggieservice.MainActivity
import com.example.diggieservice.R
import com.example.diggieservice.databinding.ActivityLoginBinding
import com.example.diggieservice.databinding.ActivityMainBinding
import com.example.rdiandroiddevelopertest.repository.NavigatorRepository
import com.example.rdiandroiddevelopertest.repository.NavigatorRepository.openMainActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var _binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        _binding.btnLogin.setOnClickListener {
            openMainActivity(this)
        }
    }
}