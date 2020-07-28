package com.daniel.movieslist

import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daniel.common.extension.bind
import com.daniel.common.extension.gone
import com.daniel.common.extension.visible
import com.daniel.movieslist.di.moviesListModule
import com.daniel.widget.ErrorView
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import androidx.core.os.LocaleListCompat
import com.daniel.common.Consts
import com.daniel.domain.entity.Movie
import com.daniel.navigator.MovieDetailsNavigator

class MoviesListActivity : AppCompatActivity() {

    private val progressBar by bind<ProgressBar>(R.id.activity_movies_list_loading)
    private val rvMovies by bind<RecyclerView>(R.id.activity_movies_list_rv_movies)
    private val errorView by bind<ErrorView>(R.id.activity_movies_list_error_view)

    private val viewModel by viewModel<MoviesListViewModel>()
    private val moviesListAdapter = MoviesListAdapter(this, ::onMovieClicked)
    private val currentLanguage = LocaleListCompat.getDefault()[0].toLanguageTag()

    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies_list)
        loadKoinModules(moviesListModule)
        setupList()
        setupObservers()
        viewModel.getTopRatedMovies(1, currentLanguage)
    }

    @ExperimentalCoroutinesApi
    override fun onResume() {
        super.onResume()
        viewModel.onLoadScreen(1, currentLanguage)
    }

    private fun setupList() {
        rvMovies.apply {
            adapter = moviesListAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun setupObservers() {
        viewModel.moviesListLv.observe(this, Observer { movies ->
            moviesListAdapter.setupMovies(movies)
        })

        viewModel.viewStateLv.observe(this, Observer { viewState ->
            @Suppress("NON_EXHAUSTIVE_WHEN")
            when (viewState) {
                MoviesListViewModel.ViewState.LOADING -> handleLoadingState()
                MoviesListViewModel.ViewState.ERROR -> handleErrorState()
                MoviesListViewModel.ViewState.EMPTY -> handleEmptyState()
                MoviesListViewModel.ViewState.LIST -> handleListState()
            }
        })
    }

    private fun handleLoadingState() {
        progressBar.visible()
        rvMovies.gone()
    }

    private fun handleEmptyState() {
        //TODO: Create empty view
    }

    private fun handleErrorState() {
        progressBar.gone()
        rvMovies.gone()
        errorView.visible()
    }

    private fun handleListState() {
        progressBar.gone()
        rvMovies.visible()
    }

    private fun onMovieClicked(movie: Movie) {
        val intent = MovieDetailsNavigator.getIntent()?.putExtra(Consts.KEY_MOVIE, movie)
        startActivity(intent)
    }
}
