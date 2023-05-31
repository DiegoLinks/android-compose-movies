package com.compose.movies.domain.model

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.compose.movies.presentation.ui.MyMoviesTheme
import com.compose.movies.presentation.utils.Dimens.spacingMedium

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MovieItem(movie: Movie) {
    Column(
        modifier = Modifier
            .padding(spacingMedium)
    ) {
        GlideImage(
            model = movie.coverImage,
            contentDescription = null,
            modifier = Modifier.size(width = 192.dp, height = 288.dp)
        )
        Text(text = movie.title)
        Text(text = movie.releaseYear.toString())
        Text(text = movie.genre)
    }
}

@Preview(showBackground = true)
@Composable
fun MovieItemScreenPreview() {
    MyMoviesTheme(darkTheme = false) {
        MovieItem(
            Movie(
                id = 0,
                title = "Synchronic",
                coverImage = "https://m.media-amazon.com/images/M/MV5BMzdlNGNiNTAtNDAyZC00NmQwLTg3ZTYtNDQ4MmNiYTc2ZmYzXkEyXkFqcGdeQXVyMDM2NDM2MQ@@._V1_.jpg",
                releaseYear = 2019,
                genre = "Ficção científica/Suspense"
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DarkMovieItemScreenPreview() {
    MyMoviesTheme(darkTheme = true) {
        MovieItem(
            Movie(
                id = 1,
                title = "Gladiador",
                coverImage = "https://upload.wikimedia.org/wikipedia/pt/4/44/GladiadorPoster.jpg",
                releaseYear = 2000,
                genre = "Aventura/Ação"
            )
        )
    }
}
