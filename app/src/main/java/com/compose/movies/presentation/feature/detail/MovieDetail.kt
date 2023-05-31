package com.compose.movies.presentation.feature.detail

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.compose.movies.presentation.ui.MyMoviesTheme

@Composable
fun MovieDetail() {

}

@Preview(showBackground = true)
@Composable
fun MovieDetailScreenPreview() {
    MyMoviesTheme(darkTheme = false) {
        MovieDetail()
    }
}

@Preview(showBackground = true)
@Composable
fun DarkMovieDetailScreenPreview() {
    MyMoviesTheme(darkTheme = true) {
        MovieDetail()
    }
}