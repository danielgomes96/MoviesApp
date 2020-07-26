package com.daniel.data.repository.movieslist

import com.daniel.data.mapper.MoviesMapper
import com.daniel.data.network.MoviesService
import com.daniel.domain.repository.MoviesListRepository
import kotlinx.coroutines.flow.flow

class MoviesListRepositoryImpl(
    private val moviesService: MoviesService,
    private val moviesMapper: MoviesMapper
) : MoviesListRepository {

    override fun getTopRatedMovies() = flow {
        emit(
            moviesMapper.transform(moviesService.getTopRated(1))
        )
    }
}