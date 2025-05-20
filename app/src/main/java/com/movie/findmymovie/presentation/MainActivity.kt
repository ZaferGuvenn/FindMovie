package com.movie.findmymovie.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.movie.findmymovie.presentation.movie_detail.views.MovieDetailScreen
import com.movie.findmymovie.presentation.movies.views.MoviesScreen
import com.movie.findmymovie.presentation.ui.FindMyMovieTheme
import com.movie.findmymovie.util.Constants.IMDB_ID
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FindMyMovieTheme {

                Surface(color = MaterialTheme.colorScheme.background) {

                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.MoviesScreen.route){
                        composable(route= Screen.MoviesScreen.route) {

                            MoviesScreen(navController = navController)
                        }

                        composable(route= Screen.MovieDetailScreen.route+"/{${IMDB_ID}}") {

                            MovieDetailScreen()
                        }
                    }

                }
            }
        }
    }
}