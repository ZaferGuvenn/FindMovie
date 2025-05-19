package com.movie.findmymovie.data.remote

import com.movie.findmymovie.data.remote.dto.MovieDetailDto
import com.movie.findmymovie.data.remote.dto.MoviesDto
import com.movie.findmymovie.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

//https://omdbapi.com/?apikey=77836e9f&s=batman
//https://omdbapi.com/?apikey=77836e9f&i=tt1877830

interface MovieAPI {

    @GET(".")
    suspend fun getMovies(
        @Query("apikey") apiKey : String = API_KEY,
        @Query("s") searchString : String
    ) : MoviesDto

    @GET(".")
    suspend fun getMovieDetail(
        @Query("apikey") apiKey: String = API_KEY,
        @Query("i") imdbId : String
    ) : MovieDetailDto

}