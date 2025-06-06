package com.ahmeterdem.foodica

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.ahmeterdem.foodica.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlin.io.root

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Burada navHostFragment id'si XML ile birebir aynı olmalı.
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController

        // Menü ile navController'ı bağla, böylece otomatik handle olur.
        binding.bottomNav.setupWithNavController(navController)

        // Eğer manuel kontrol istersen aşağıdaki gibi kullanabilirsin:
        // setupBottomNav()
    }


}