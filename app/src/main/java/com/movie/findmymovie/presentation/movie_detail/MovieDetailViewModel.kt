package com.movie.findmymovie.presentation.movie_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movie.findmymovie.domain.model.MovieDetail
import com.movie.findmymovie.domain.usecase.getMovieDetail.GetMovieDetailUseCase
import com.movie.findmymovie.util.Constants.IMDB_ID
import com.movie.findmymovie.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(

    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    private val savedStateHandle: SavedStateHandle

): ViewModel(){

    private val _state = mutableStateOf<MovieDetailState>(MovieDetailState())
    val state : State<MovieDetailState> = _state

    init {
        savedStateHandle.get<String>(IMDB_ID)?.let {


            println("it")
            println(it)
            getMovieDetail(it)
        }
    }

    private fun getMovieDetail(imdbId:String){
        println("imdbId")
        println(imdbId)
        getMovieDetailUseCase.executeGetMovieDetail(imdbId).onEach {

            println(it)
            when(it) {
                is NetworkResult.Success -> _state.value = MovieDetailState(movieDetail = it.data)
                is NetworkResult.Error -> _state.value = MovieDetailState(error = it.message ?: "Unknown error!")
                is NetworkResult.Loading -> _state.value = MovieDetailState(isLoading = true)
            }

        }.launchIn(viewModelScope)
    }


}