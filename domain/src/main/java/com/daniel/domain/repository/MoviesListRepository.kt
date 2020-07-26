package com.daniel.domain.repository

import com.daniel.domain.entity.Movie
import kotlinx.coroutines.flow.Flow

interface MoviesListRepository {
    fun getTopRatedMovies(): Flow<List<Movie>>
}