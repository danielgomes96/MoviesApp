package com.daniel.domain.usecase.movieslist

import com.daniel.domain.repository.MoviesListRepository

class GetTopRatedMoviesUseCaseImpl(
    private val moviesListRepository: MoviesListRepository
) : GetTopRatedMoviesUseCase {

    override fun execute() = moviesListRepository.getTopRatedMovies()
}