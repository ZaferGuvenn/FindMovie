package com.movie.findmymovie.presentation.movies

sealed class MoviesEvent {

    data class Search(val searchString: String): MoviesEvent()

}