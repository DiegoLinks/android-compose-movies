package com.compose.movies.presentation.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.compose.movies.data.repositories.movies
import com.compose.movies.domain.model.Movie
import com.compose.movies.presentation.ui.theme.MyMoviesTheme
import com.compose.movies.presentation.utils.Dimens.fontXLarge
import com.compose.movies.presentation.utils.Dimens.spacingMedium

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MovieItem(movie: Movie, navController: NavHostController) {
    Surface(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .clickable {
                navController.navigate("detail/${movie.title}/${movie.synopsis}")
            }
    ) {
        Column(modifier = Modifier.padding(spacingMedium)) {
            GlideImage(
                model = movie.coverImage,
                contentDescription = null,//todo add some content description
                modifier = Modifier
                    .size(width = 232.dp, height = 262.dp)
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Text(
                text = movie.title,
                modifier = Modifier.padding(top = spacingMedium),
                style = MaterialTheme.typography.labelLarge,
                fontSize = fontXLarge,
                color = MaterialTheme.colorScheme.onBackground
            )

            Text(
                text = movie.releaseYear.toString(),
                color = MaterialTheme.colorScheme.onBackground
            )

            Text(text = movie.genre[0], color = MaterialTheme.colorScheme.onBackground)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieItemScreenPreview() {
    MyMoviesTheme(darkTheme = false) {
        MovieItem(movies[0], rememberNavController())
    }
}

@Preview(showBackground = true)
@Composable
fun DarkMovieItemScreenPreview() {
    MyMoviesTheme(darkTheme = true) {
        MovieItem(movies[0], rememberNavController())
    }
}
