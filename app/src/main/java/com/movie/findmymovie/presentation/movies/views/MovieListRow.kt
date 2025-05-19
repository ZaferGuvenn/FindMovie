package com.movie.findmymovie.presentation.movies.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import com.movie.findmymovie.domain.model.Movie

@Composable
fun MovieListRow(
    movie: Movie,
    onItemClick :(Movie)->Unit
) {


    Row (
        modifier = Modifier
            .fillMaxWidth()
            .clickable{
                onItemClick(movie)
            }
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){

        Image(
            painter = rememberAsyncImagePainter(
                //model = "https://upload.wikimedia.org/wikipedia/commons/thumb/4/40/Thomas_Edison2-crop.jpg/640px-Thomas_Edison2-crop.jpg"
                model = movie.poster
            ),
            contentDescription = movie.title,
            modifier = Modifier
                .padding(0.dp)
                .size(200.dp, 200.dp)
                .clip(CircleShape)
            )

        Column(modifier = Modifier.align(CenterVertically),horizontalAlignment = Alignment.CenterHorizontally) {
            Text(movie.title,
                style = MaterialTheme.typography.titleMedium,
                overflow = TextOverflow.Ellipsis,
                color = White,
                textAlign = TextAlign.Center
            )

            Text(movie.year,
                style = MaterialTheme.typography.titleLarge,
                overflow = TextOverflow.Ellipsis,
                color = White,
                textAlign = TextAlign.Center
            )

        }

    }



}
