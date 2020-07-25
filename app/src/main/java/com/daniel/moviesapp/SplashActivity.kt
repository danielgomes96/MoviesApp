package com.daniel.moviesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.daniel.navigator.MoviesListNavigator

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val intent = MoviesListNavigator.getIntent()
        startActivity(intent)
        finish()
    }
}
