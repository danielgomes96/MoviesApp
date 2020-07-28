package com.daniel.data.mapper

import com.daniel.data.dto.DTOMoviesList
import com.daniel.domain.entity.Movie

class MoviesMapper : BaseMapper<DTOMoviesList, List<Movie>>() {
    override fun transform(entity: DTOMoviesList): List<Movie> {
        return entity.moviesList.map {
            Movie(
                it.id,
                it.title,
                it.description,
                it.imageUrl,
                it.voteAverage,
                it.isAdult,
                it.releaseDate
            )
        }
    }
}
