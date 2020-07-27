package com.daniel.movieslist

import android.util.Log
import androidx.lifecycle.LiveData
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

    private val _viewStateLv: MutableLiveData<ViewState> = MutableLiveData<ViewState>()
    val viewStateLv: LiveData<ViewState>
        get() = _viewStateLv

    @ExperimentalCoroutinesApi
    fun onLoadScreen(page: Int, language: String) {
        val shouldShowLoading = _viewStateLv.value in arrayOf(ViewState.IDLE, ViewState.ERROR)
        if (shouldShowLoading) _viewStateLv.value = ViewState.LOADING
        getTopRatedMovies(page, language)
    }

    @ExperimentalCoroutinesApi
    fun getTopRatedMovies(page: Int, language: String) {
        launch {
            getTopRatedMoviesUseCase.execute(page, language)
                .catch {
                    Log.e("Error!", "Error!")
                }
                .collect {
                    _viewStateLv.postValue(ViewState.LIST)
                    moviesListLv.postValue(it)
                }
        }
    }

    enum class ViewState {
        IDLE, LOADING, ERROR, EMPTY, LIST
    }
}