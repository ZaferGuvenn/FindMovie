package com.movie.findmymovie.data.repository

import com.movie.findmymovie.data.remote.MovieAPI
import com.movie.findmymovie.data.remote.dto.MovieDetailDto
import com.movie.findmymovie.data.remote.dto.MoviesDto
import com.movie.findmymovie.domain.repository.MovieRepository
import javax.inject.Inject


class MovieRepositoryImpl @Inject constructor(private val movieAPI: MovieAPI): MovieRepository {
    override suspend fun getMovies(searchString: String): MoviesDto {
        return movieAPI.getMovies(searchString = searchString)
    }

    override suspend fun getMovieDetail(imdbId: String): MovieDetailDto {
       return movieAPI.getMovieDetail(imdbId = imdbId)
    }
}