package com.movie.findmymovie.presentation.movies

import com.movie.findmymovie.domain.model.Movie

data class MoviesState(
    val isLoading:Boolean = false,
    val movies : List<Movie> = emptyList(),
    val error : String = "",
    val firstSearch : String = "batman"
)