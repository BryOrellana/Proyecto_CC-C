package com.mauricio.moviles_bg2m

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.mauricio.moviles_bg2m.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)


        setupNavigation()
        colorToolbar()
    }

    fun setupNavigation() {
        val navController = this.findNavController(R.id.myNavHostFragment)
        bottom_navigation.setupWithNavController(navController)
        NavigationUI.setupActionBarWithNavController(this, navController)

        var appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = setOf(
                R.id.homeFragment,
                R.id.productsFragment,
                R.id.moreFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    private fun colorToolbar() {
        val actionBar: ActionBar?
        actionBar = supportActionBar

        val colorDrawable = ColorDrawable(Color.parseColor("#00303f"))

        actionBar?.setBackgroundDrawable(colorDrawable);
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }
}