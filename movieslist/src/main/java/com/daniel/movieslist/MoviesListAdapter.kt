package com.daniel.movieslist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.daniel.common.extension.renderUrl
import com.daniel.domain.entity.Movie

class MoviesListAdapter(
    private val context: Context
) : RecyclerView.Adapter<MoviesListAdapter.ItemViewHolder>() {

    private var moviesList = emptyList<Movie>()

    fun setupMovies(moviesList: List<Movie>) {
        this.moviesList = moviesList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(context, moviesList[position])
    }

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvTitle = view.findViewById<TextView>(R.id.movie_item_title)
        private val tvDescription = view.findViewById<TextView>(R.id.movie_item_description)
        private val imImage = view.findViewById<ImageView>(R.id.movie_item_image)

        fun bind(context: Context, movie: Movie) {
            tvTitle.text = movie.name
            tvDescription.text = movie.description
            imImage.renderUrl(context, "http://image.tmdb.org/t/p/w185" + movie.imageUrl)
        }
    }
}