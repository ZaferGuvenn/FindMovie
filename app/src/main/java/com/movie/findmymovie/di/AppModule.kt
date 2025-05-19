package com.movie.findmymovie.di

import com.movie.findmymovie.data.remote.MovieAPI
import com.movie.findmymovie.data.repository.MovieRepositoryImpl
import com.movie.findmymovie.domain.repository.MovieRepository
import com.movie.findmymovie.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMovieAPI(): MovieAPI{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(api: MovieAPI) : MovieRepository{
        return MovieRepositoryImpl(api)
    }

}