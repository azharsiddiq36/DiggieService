package com.example.diggieservice

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.diggieservice.databinding.ActivityMainBinding
import com.example.diggieservice.feature.home.CobaViewModel
import com.example.diggieservice.feature.home.HomeViewModel
import com.example.rdiandroiddevelopertest.repository.RetrofitRepository
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//    private val cobaViewModel: CobaViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_account, R.id.navigation_history,R.id.navigation_service,R.id.navigation_service
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
//        cobaViewModel.coba()
    }
}