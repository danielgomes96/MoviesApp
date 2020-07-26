package com.daniel.domain.di

import com.daniel.domain.usecase.movieslist.GetTopRatedMoviesUseCase
import com.daniel.domain.usecase.movieslist.GetTopRatedMoviesUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    factory {
        GetTopRatedMoviesUseCaseImpl(get()) as GetTopRatedMoviesUseCase
    }
}