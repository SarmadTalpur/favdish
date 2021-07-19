package com.example.favdish.view.activities

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.favdish.R
import com.example.favdish.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mbinding: ActivityMainBinding
    private lateinit var mNavController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mbinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mbinding.root)

        mNavController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_all_dishes, R.id.navigation_random_dish, R.id.navigation_favorite_dishes
            )
        )
        setupActionBarWithNavController(mNavController, appBarConfiguration)
        mbinding.navView.setupWithNavController(mNavController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(mNavController, null)
    }

    fun hideBottomNavigationView() {
        mbinding.navView.clearAnimation()
        mbinding.navView.animate().translationY(mbinding.navView.height.toFloat()).duration = 300
    }

    fun showBottomNavigationView() {
        mbinding.navView.clearAnimation()
        mbinding.navView.animate().translationY(0f).duration = 300
    }

}