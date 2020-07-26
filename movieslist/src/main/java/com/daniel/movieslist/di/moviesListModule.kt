package com.daniel.movieslist.di

import com.daniel.movieslist.MoviesListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val moviesListModule = module {
    viewModel {
        MoviesListViewModel(get())
    }
}