package com.daniel.domain.usecase.movieslist

import com.daniel.domain.entity.Movie
import kotlinx.coroutines.flow.Flow

interface GetTopRatedMoviesUseCase {
    fun execute(): Flow<List<Movie>>
}