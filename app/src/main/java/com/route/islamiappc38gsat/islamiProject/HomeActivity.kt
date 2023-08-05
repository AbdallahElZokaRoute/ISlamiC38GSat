package com.route.islamiappc38gsat.islamiProject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.route.islamiappc38gsat.R
import com.route.islamiappc38gsat.islamiProject.fragments.HadethFragment
import com.route.islamiappc38gsat.islamiProject.fragments.QuranFragment
import com.route.islamiappc38gsat.islamiProject.fragments.RadioFragment
import com.route.islamiappc38gsat.islamiProject.fragments.SebhaFragment

class HomeActivity : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomNavigationView = findViewById(R.id.bottom_navigation_view)
        bottomNavigationView.setOnItemSelectedListener {
            if (it.itemId == R.id.navigation_quran) {
                pushFragment(QuranFragment())
            } else if (it.itemId == R.id.navigation_hadeth) {
                pushFragment(HadethFragment())
            } else if (it.itemId == R.id.navigation_sebha) {
                pushFragment(SebhaFragment())
            } else if (it.itemId == R.id.navigation_radio) {
                pushFragment(RadioFragment())
            }

            return@setOnItemSelectedListener true
        }
        bottomNavigationView.selectedItemId = R.id.navigation_quran
    }

    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.islami_fragment_container, fragment)
            .commit()
    }
}