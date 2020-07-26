package com.daniel.movieslist

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.daniel.movieslist.di.moviesListModule
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class MoviesListActivity : AppCompatActivity() {

    private val viewModel by viewModel<MoviesListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies_list)
        loadKoinModules(moviesListModule)
        viewModel.getTopRatedMovies()
        viewModel.moviesListLv.observe(this, Observer {
            Log.e("Movies from page 1:", it.toString())
        })
    }
}