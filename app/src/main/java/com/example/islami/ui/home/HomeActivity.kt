package com.example.islami.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.islami.R
import com.example.islami.ui.hadeth.HadethFragment
import com.example.islami.ui.quran.QuranFragment
import com.example.islami.ui.radio.RadioFragment
import com.example.islami.ui.tasbeh.TasbehFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomNav = findViewById(R.id.navigation_home)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navi_quran -> {
                    showTab(QuranFragment())
                }

                R.id.navi_hadeth -> {
                    showTab(HadethFragment())
                }

                R.id.navi_tasbeh -> {
                    showTab(TasbehFragment())
                }

                R.id.navi_radio -> {
                    showTab(RadioFragment())
                }
            }
            return@setOnItemSelectedListener true
        }
        bottomNav.selectedItemId = R.id.navi_quran
    }

    fun showTab(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}