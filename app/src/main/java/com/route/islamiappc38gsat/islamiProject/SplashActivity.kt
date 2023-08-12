package com.route.islamiappc38gsat.islamiProject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import com.route.islamiappc38gsat.R
import com.route.islamiappc38gsat.designPatterns.database1
import com.route.islamiappc38gsat.designPatterns.database2
import com.route.islamiappc38gsat.islamiProject.data.Constants

class SplashActivity : AppCompatActivity() {
    /**
     * Light & Dark Mode
     * SharedPreference
     * Design Patterns (Creational & Structural & Behavioral Patterns) (Singleton Pattern)
     * Database Concept & Room DataBase
     * TO-Do App
     */
    fun getModeFromSharedPreference(): Int {
        val sharedPreferences =
            getSharedPreferences(Constants.ISLAMI_SHARED_PREFERENCE, Context.MODE_PRIVATE)
        return sharedPreferences.getInt(Constants.ISLAMI_MODE_KEY, AppCompatDelegate.MODE_NIGHT_NO)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (getModeFromSharedPreference() == AppCompatDelegate.MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
        Log.e("TAG", "onCreate: ${database1.hashCode()}")
        Log.e("TAG", "onCreate: ${database2.hashCode()}")
        setContentView(R.layout.activity_splash)
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@SplashActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }, 2500)
    }
}