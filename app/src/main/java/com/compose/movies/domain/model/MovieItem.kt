package com.compose.movies.domain.model

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.compose.movies.data.repositories.movies
import com.compose.movies.presentation.ui.MyMoviesTheme
import com.compose.movies.presentation.utils.Dimens.spacingMedium

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MovieItem(movie: Movie, navController: NavHostController) {
    Column(
        modifier = Modifier
            .padding(spacingMedium)
            .clickable {
                navController.navigate("detail/${movie.title}/${movie.synopsis}")
            }
    ) {
        GlideImage(
            model = movie.coverImage,
            contentDescription = null,
            modifier = Modifier.size(width = 192.dp, height = 288.dp)
        )
        Text(text = movie.title)
        Text(text = movie.releaseYear.toString())
        Text(text = movie.genre[0])
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
