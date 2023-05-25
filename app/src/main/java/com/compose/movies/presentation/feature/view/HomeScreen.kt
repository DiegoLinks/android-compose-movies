package com.compose.movies.presentation.feature.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.compose.movies.presentation.ui.MyMoviesTheme
import com.compose.movies.presentation.ui.component.TopAppBar

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        TopAppBar(title = "Home")
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MyMoviesTheme(darkTheme = false) {
        HomeScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun DarkHomeScreenPreview() {
    MyMoviesTheme(darkTheme = true) {
        HomeScreen()
    }
}