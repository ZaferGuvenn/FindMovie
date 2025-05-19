package com.movie.findmymovie.domain.usecase.getMovieDetail

import com.movie.findmymovie.data.remote.dto.toMovieDetail
import com.movie.findmymovie.domain.model.MovieDetail
import com.movie.findmymovie.domain.repository.MovieRepository
import com.movie.findmymovie.util.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(private val repository: MovieRepository) {

    fun executeGetMovieDetail(imdbId:String): Flow<NetworkResult<MovieDetail>>{

        return flow {
            try {
                emit(NetworkResult.Loading())
                val movieDetailDto = repository.getMovieDetail(imdbId)
                emit(NetworkResult.Success(movieDetailDto.toMovieDetail()))
            }catch (e: Exception){
                emit(NetworkResult.Error(e.localizedMessage?:"Unknown Error!"))
            }
        }
    }
}