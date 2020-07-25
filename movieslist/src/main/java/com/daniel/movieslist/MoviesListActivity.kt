package com.daniel.movieslist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MoviesListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies_list)
        val test = String
        println("$test" + "a")
    }
}