package com.example.bcsnassignment.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.bcsnassignment.R
import com.example.bcsnassignment.databinding.ActivityMainBinding
import com.example.bcsnassignment.model.Test
import com.example.bcsnassignment.model.rest
import com.example.bcsnassignment.view.fragments.fragment_1
import com.example.bcsnassignment.viewmodel.BCSNPagerAdapter

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    companion object {
        const val USER = "test"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationBar = binding.bottomNavigationView

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        bottomNavigationBar.setupWithNavController(navController)
    }

}