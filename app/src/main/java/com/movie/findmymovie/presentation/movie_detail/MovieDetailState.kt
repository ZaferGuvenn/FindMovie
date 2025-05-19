package com.movie.findmymovie.presentation.movie_detail

import com.movie.findmymovie.domain.model.MovieDetail

data class MovieDetailState  (
    val isLoading:Boolean=false,
    val movieDetail:MovieDetail?=null,
    val error: String=""
)