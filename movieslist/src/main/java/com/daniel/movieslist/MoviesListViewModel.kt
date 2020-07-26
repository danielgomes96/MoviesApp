package com.daniel.movieslist

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.daniel.common.BaseViewModel
import com.daniel.domain.entity.Movie
import com.daniel.domain.usecase.movieslist.GetTopRatedMoviesUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MoviesListViewModel(
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase
) : BaseViewModel() {

    var moviesListLv: MutableLiveData<List<Movie>> = MutableLiveData()

    @ExperimentalCoroutinesApi
    fun getTopRatedMovies() {
        launch {
            getTopRatedMoviesUseCase.execute()
                .catch {
                    Log.e("errou!", "errou!")
                }
                .collect {
                    moviesListLv.postValue(it)
                }
        }
    }
}