package com.compose.movies.presentation.feature.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.compose.movies.R
import com.compose.movies.data.repositories.movies
import com.compose.movies.domain.model.Movie
import com.compose.movies.presentation.ui.component.TopAppBar
import com.compose.movies.presentation.ui.theme.MyMoviesTheme
import com.compose.movies.presentation.utils.Dimens
import com.compose.movies.presentation.utils.Dimens.spacingLarge
import com.compose.movies.presentation.utils.Dimens.spacingMedium
import com.compose.movies.presentation.utils.Dimens.spacingXLarge

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MovieDetail(movie: Movie) {
    val title = stringResource(id = R.string.movie_detail_title)
    val yearLabel = stringResource(id = R.string.year_label, movie.releaseYear.toString())
    val genreLabel = stringResource(id = R.string.genre_label, movie.genre[0])
    val directorLabel = stringResource(id = R.string.director_label, movie.director)
    val countryLabel = stringResource(id = R.string.country_label, movie.country.name)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        TopAppBar(title = title)
        Text(
            modifier = Modifier.padding(spacingMedium),
            text = movie.title,
            fontSize = Dimens.fontXLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            modifier = Modifier.padding(horizontal = spacingMedium),
            text = yearLabel,
            fontSize = Dimens.fontSmall,
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            modifier = Modifier.padding(horizontal = spacingMedium),
            text = genreLabel,
            fontSize = Dimens.fontSmall,
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            modifier = Modifier.padding(horizontal = spacingMedium),
            text = directorLabel,
            fontSize = Dimens.fontSmall,
            color = MaterialTheme.colorScheme.onBackground
        )
        Row {
            Text(
                modifier = Modifier.padding(horizontal = spacingMedium),
                text = countryLabel,
                fontSize = Dimens.fontSmall,
                color = MaterialTheme.colorScheme.onBackground
            )

            GlideImage(
                model = movie.country.flagUrl,
                contentDescription = null,//todo add some content description
                modifier = Modifier
                    .size(width = spacingXLarge, height = spacingLarge)
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
        Text(
            modifier = Modifier.padding(spacingMedium),
            text = movie.synopsis,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MovieDetailScreenPreview() {
    MyMoviesTheme(darkTheme = false) {
        MovieDetail(movies[0])
    }
}

@Preview(showBackground = true)
@Composable
fun DarkMovieDetailScreenPreview() {
    MyMoviesTheme(darkTheme = true) {
        MovieDetail(movies[0])
    }
}