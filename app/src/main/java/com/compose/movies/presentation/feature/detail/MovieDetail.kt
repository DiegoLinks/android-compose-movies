package com.compose.movies.presentation.feature.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.compose.movies.presentation.ui.MyMoviesTheme
import com.compose.movies.presentation.utils.Dimens.spacingMedium

@Composable
fun MovieDetail(title: String, synopsis: String) {
    Column(
        modifier = Modifier
            .padding(spacingMedium)
    ) {
        Text(modifier = Modifier.padding(spacingMedium), text = title)
        Text(modifier = Modifier.padding(spacingMedium), text = synopsis)
    }
}

@Preview(showBackground = true)
@Composable
fun MovieDetailScreenPreview() {
    MyMoviesTheme(darkTheme = false) {
        MovieDetail(
            "Synchronic",
            "Os paramédicos Steve e Dennis, de Nova Orleans, são chamados para socorrer vítimas de uma série de acidentes horríveis, eles logo descobrem a existência de uma nova droga, capaz de alterar a realidade."
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DarkMovieDetailScreenPreview() {
    MyMoviesTheme(darkTheme = true) {
        MovieDetail(
            "Synchronic",
            "Os paramédicos Steve e Dennis, de Nova Orleans, são chamados para socorrer vítimas de uma série de acidentes horríveis, eles logo descobrem a existência de uma nova droga, capaz de alterar a realidade."
        )
    }
}