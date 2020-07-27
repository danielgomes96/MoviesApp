package com.daniel.movieslist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.daniel.common.extension.format
import com.daniel.common.extension.gone
import com.daniel.common.extension.renderUrl
import com.daniel.common.extension.visible
import com.daniel.domain.entity.Movie
import java.text.SimpleDateFormat
import java.util.*

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
        private val tvScore = view.findViewById<TextView>(R.id.movie_item_score)
        private val imImage = view.findViewById<ImageView>(R.id.movie_item_image)
        private val tvReleaseDate = view.findViewById<TextView>(R.id.movie_item_release_date)
        private val imPlus18 = view.findViewById<ImageView>(R.id.movie_item_im_plus18)

        fun bind(context: Context, movie: Movie) = with(movie) {
            tvTitle.text = name
            tvDescription.text = description
            imImage.renderUrl(context, "http://image.tmdb.org/t/p/w185$imageUrl")
            tvScore.text = voteAverage.toString()
            tvReleaseDate.text = String.format(
                    context.getString(R.string.movie_release_date,
                    releaseDate.format("dd/MM/yyyy")
                )
            )
            if (isAdult) {
                imPlus18.visible()
            } else {
                imPlus18.gone()
            }
        }


    }
}