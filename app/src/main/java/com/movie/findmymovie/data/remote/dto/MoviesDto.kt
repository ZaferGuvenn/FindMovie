package com.movie.findmymovie.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.movie.findmymovie.domain.model.Movie

data class MoviesDto(

    @SerializedName("Response")
    val response: String,

    @SerializedName("Search")
    val search: List<Search>,

    val totalResults: String
)

fun MoviesDto.toMovieList(): List<Movie>{
    return search.map { search->//her bir eleman için dönüşüm yapıp liste döner.
        Movie(
            imdbID = search.imdbID,
            poster = search.poster,
            year = search.year,
            title = search.title
        )
    }
}