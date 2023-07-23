package com.example.speakandtranslate.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import com.example.speakandtranslate.MainActivity
import com.example.speakandtranslate.databinding.ActivitySplashBinding
import com.translate.languages.camera.languagetranslator.cameratranslator.utils.MyPreferences

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        checkTheme()
        Handler(Looper.getMainLooper()).postDelayed(
            {

                binding.loading.visibility = View.GONE
                binding.getStarted.visibility = View.VISIBLE

            }, 5000
        )

        binding.getStarted.setOnClickListener {
           val intent =  Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
           // startActivity(Intent(this@SplashActivity,MainActivity::class.java))
        }
    }

    private fun checkTheme() {
        when (MyPreferences(this).darkMode) {
            0 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                delegate.applyDayNight()
            }
            1 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                delegate.applyDayNight()
            }
            2 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                delegate.applyDayNight()
            }
        }
    }
}