package com.movie.findmymovie.domain.repository

import com.movie.findmymovie.data.remote.MovieAPI
import com.movie.findmymovie.data.remote.dto.MovieDetailDto
import com.movie.findmymovie.data.remote.dto.MoviesDto

interface MovieRepository {

    suspend fun getMovies(searchString: String): MoviesDto
    suspend fun getMovieDetail(imdbId:String): MovieDetailDto
}