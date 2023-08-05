package com.route.islamiappc38gsat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    // Fragments
    // Git & Github (Version Control Systems ) "VCS"
    // 1- 5 Works On A project
    // 2- Hardware Failures -> Project X
    // 3- Team Work ->
    // Repository ->

    lateinit var profileTextView: TextView
    lateinit var settingsTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        profileTextView = findViewById(R.id.profile_tab)
        settingsTextView = findViewById(R.id.settings_tab)
        pushFragment(ProfileFragment())
        profileTextView.setOnClickListener {
            // Add Or Remove Or replace fragment
            pushFragment(ProfileFragment())
        }
        settingsTextView.setOnClickListener {
            val settingsFragment = SettingsFragment()
            pushFragment(settingsFragment)
        }
    }

    // Profile Fragment
    // SettingsFragment
    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            //.addToBackStack(null)
            .commit()
    }


}