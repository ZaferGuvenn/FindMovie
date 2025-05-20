package com.movie.findmymovie.presentation.movies.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.movie.findmymovie.presentation.movies.MoviesViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import com.movie.findmymovie.presentation.Screen
import com.movie.findmymovie.presentation.movies.MoviesEvent

@Composable
fun MoviesScreen(navController: NavController, viewModel: MoviesViewModel = hiltViewModel()){

    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize().background(Color.Blue)){

        Column {

            // movie search bar
            MovieSearchBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),

                hint = "Batman",
                onSearch = {
                    viewModel.onEvent(MoviesEvent.Search(it))
                }
            )

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.movies) { movie ->
                    MovieListRow(movie = movie, onItemClick = {
                        //navigate to details
                        navController.navigate(Screen.MovieDetailScreen.route+"/${movie.imdbID}")
                    })
                }
            }



        }



    }

}