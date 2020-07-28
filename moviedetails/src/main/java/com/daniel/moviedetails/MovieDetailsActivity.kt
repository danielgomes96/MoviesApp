package com.daniel.moviedetails

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.daniel.common.Consts
import com.daniel.common.extension.bind
import com.daniel.common.extension.renderUrl
import com.daniel.domain.entity.Movie
class MovieDetailsActivity : AppCompatActivity() {

    private val tvTitle by bind<TextView>(R.id.activity_movie_details_txt_title)
    private val tvDescription by bind<TextView>(R.id.activity_movie_details_txt_description)
    private val imImage by bind<ImageView>(R.id.activity_movie_details_image)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        title = getString(R.string.movie_details_title)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val movie = intent.getSerializableExtra(Consts.KEY_MOVIE) as Movie
        setupMovieDetails(movie)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        return true
    }

    private fun setupMovieDetails(movie: Movie) = with(movie) {
        imImage.renderUrl(this@MovieDetailsActivity,
            "http://image.tmdb.org/t/p/w300$imageUrl")
        tvTitle.text = name
        tvDescription.text = description
    }
}