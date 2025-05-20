package com.movie.findmymovie.presentation.movie_detail.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.movie.findmymovie.presentation.movie_detail.MovieDetailViewModel

import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter

@Composable
fun MovieDetailScreen(
    movieDetailViewModel: MovieDetailViewModel = hiltViewModel()
) {

    val state = movieDetailViewModel.state.value

    Box(modifier = Modifier.fillMaxSize().background(Color.Transparent),
        contentAlignment = Center){

        state.movieDetail?.let {

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(
                    painter = rememberAsyncImagePainter(it.poster),
                    contentDescription = it.title,
                    modifier = Modifier
                        .padding(16.dp)
                        .size(300.dp, 300.dp)
                        .clip(RectangleShape)
                        .align(Alignment.CenterHorizontally)
                )

                Text(
                    text = it.title,
                    modifier = Modifier.padding(14.dp),
                    color = Color.Black
                )

                Text(
                    text = it.year,
                    modifier = Modifier.padding(14.dp)
                )

                Text(
                    text = it.actors,
                    modifier = Modifier.padding(14.dp)
                )

                Text(
                    text = it.country,
                    modifier = Modifier.padding(14.dp)
                )

                Text(
                    text = "Director: ${it.director}",
                    modifier = Modifier.padding(14.dp)
                )

                Text(
                    text = "IMDB Rating: ${it.imdbRating}",
                    modifier = Modifier.padding(14.dp)
                )
            }



        }

        if (state.error.isNotBlank()){

            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp)
                    .align(Alignment.Center)
            )
        }

        if (state.isLoading){
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }

    }
}