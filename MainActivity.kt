package com.example.workdiary

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.HandlerCompat

class MainActivity : AppCompatActivity() {

    private val SPLASH_DELAY: Long = 2000 // 2 seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Delay the screen transition to simulate a splash screen
        val handler = HandlerCompat.createAsync(mainLooper)
        handler.postDelayed({
            navigateToNextScreen()
        }, SPLASH_DELAY)
    }

    private fun navigateToNextScreen() {
        val intent = Intent(this, DashboardScreen::class.java)
        startActivity(intent)
        finish() // Finish the splash screen activity to prevent going back to it
    }
}
