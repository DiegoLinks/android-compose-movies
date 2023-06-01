package com.compose.movies.presentation.feature.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.compose.movies.data.repositories.movies
import com.compose.movies.presentation.ui.component.TopAppBar
import com.compose.movies.presentation.ui.theme.MyMoviesTheme
import com.compose.movies.presentation.utils.Dimens.spacingMedium

@Composable
fun MovieDetail(title: String, synopsis: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        TopAppBar(title = "Detail")
        Text(
            modifier = Modifier.padding(spacingMedium),
            text = title,
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            modifier = Modifier.padding(spacingMedium),
            text = synopsis,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MovieDetailScreenPreview() {
    MyMoviesTheme(darkTheme = false) {
        MovieDetail(
            movies[0].title,
            movies[0].synopsis
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DarkMovieDetailScreenPreview() {
    MyMoviesTheme(darkTheme = true) {
        MovieDetail(
            movies[0].title,
            movies[0].synopsis
        )
    }
}