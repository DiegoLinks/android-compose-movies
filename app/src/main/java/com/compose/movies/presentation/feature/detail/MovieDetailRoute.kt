package com.compose.movies.presentation.feature.detail

import androidx.compose.runtime.Composable
import com.compose.movies.domain.repository.getMovieById

@Composable
fun MovieDetailRoute(movieId: Int) {
    val movie = getMovieById(movieId)

    if (movie == null) {
        //todo exception scenario
    } else {
        MovieDetailScreen(movie)
    }
}