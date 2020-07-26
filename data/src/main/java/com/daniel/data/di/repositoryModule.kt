package com.daniel.data.di

import com.daniel.data.mapper.MoviesMapper
import com.daniel.data.repository.movieslist.MoviesListRepositoryImpl
import com.daniel.domain.repository.MoviesListRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory {
        MoviesListRepositoryImpl(get(), get()) as MoviesListRepository
    }

    factory {
        MoviesMapper()
    }
}