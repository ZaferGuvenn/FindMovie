package com.movie.findmymovie.presentation.movies

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movie.findmymovie.domain.usecase.getMovies.GetMoviesUseCase
import com.movie.findmymovie.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor (private val getMoviesUseCase: GetMoviesUseCase): ViewModel() {


    private val _state = mutableStateOf<MoviesState>(MoviesState())
    val state : State<MoviesState> = _state

    private var job :Job? = null
    init {
        getMovies(_state.value.firstSearch)//batman
    }

    private fun getMovies(searchString:String){
        job?.cancel()

        job= getMoviesUseCase.executeGetMovies(searchString).onEach {

            when(it){

                is NetworkResult.Success->{
                    _state.value = MoviesState(movies = it.data?:emptyList())
                }
                is NetworkResult.Error->{
                    _state.value = MoviesState(error = it.message?:"Error")
                }
                is NetworkResult.Loading->{
                    _state.value = MoviesState(isLoading = true)
                }

            }

        }.launchIn(viewModelScope)
    }

    fun onEvent(event:MoviesEvent){
        when(event){
            is MoviesEvent.Search ->{ getMovies(event.searchString)}
        }
    }

}