package com.example.mvvm_practice_android.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvm_practice_android.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        setContentView(R.layout.activity_main)

        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.bottom_navigation_home -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.bottom_navigation_dms -> {
                return@OnNavigationItemSelectedListener true
            }
            else -> {}
        }
        false
    }
}
