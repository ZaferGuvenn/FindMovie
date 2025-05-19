package com.movie.findmymovie.domain.usecase.getMovies

import com.movie.findmymovie.data.remote.dto.toMovieList
import com.movie.findmymovie.domain.model.Movie
import com.movie.findmymovie.domain.repository.MovieRepository
import com.movie.findmymovie.util.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(private val repository: MovieRepository) {

    fun executeGetMovies(searchString: String):Flow<NetworkResult<List<Movie>>>{
        return flow {
            try {
                emit(NetworkResult.Loading())
                val moviesDto= repository.getMovies(searchString)
                if (moviesDto.response=="True"){
                    emit(NetworkResult.Success(moviesDto.toMovieList()))
                }else{
                    emit(NetworkResult.Error("Movie not found!"))
                }
            }catch (e:IOError){
                emit(NetworkResult.Error("No internet connection!"))
            }catch (e:HttpException){
                emit(NetworkResult.Error(e.localizedMessage?:"Error http!"))
            }
        }
    }
}