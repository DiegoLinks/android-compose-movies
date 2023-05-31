package com.compose.movies.presentation.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.compose.movies.data.repositories.movies
import com.compose.movies.domain.model.Movie
import com.compose.movies.domain.model.MovieItem
import com.compose.movies.presentation.ui.MyMoviesTheme
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
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp)
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