package com.compose.movies.presentation.feature.home

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.compose.movies.data.repository.movies
import com.compose.movies.domain.model.Movie
import com.compose.movies.presentation.ui.theme.MyMoviesTheme
import com.compose.movies.presentation.ui.component.TopAppBar

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        TopAppBar(title = "Home")

        MovieList(movies = movies, navController)
    }
}

@Composable
fun MovieList(movies: List<Movie>, navController: NavHostController) {

    val configuration = LocalConfiguration.current

    val columns = when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            GridCells.Fixed(4)
        }
        else -> {
            GridCells.Fixed(2)
        }
    }

    LazyVerticalGrid(
        columns = columns
    ) {
        items(count = movies.size) { index ->
            val movie = movies[index]
            MovieItem(movie = movie, navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MyMoviesTheme(darkTheme = false) {
        HomeScreen(rememberNavController())
    }
}

@Preview(showBackground = true)
@Composable
fun DarkHomeScreenPreview() {
    MyMoviesTheme(darkTheme = true) {
        HomeScreen(rememberNavController())
    }
}