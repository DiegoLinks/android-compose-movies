package com.compose.movies.presentation.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.compose.movies.R
import com.compose.movies.domain.repository.movies
import com.compose.movies.presentation.model.MovieUI
import com.compose.movies.presentation.ui.theme.MyMoviesTheme
import com.compose.movies.presentation.ui.theme.ueRed
import com.compose.movies.presentation.utils.Dimens.fontSmall
import com.compose.movies.presentation.utils.Dimens.fontXLarge
import com.compose.movies.presentation.utils.Dimens.spacingMedium
import com.compose.movies.presentation.utils.MovieUtils.getMainMovieGender
import com.compose.movies.presentation.utils.MovieUtils.ratingTextColor

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MovieItem(movie: MovieUI, navController: NavHostController) {

    val ratingTexColor =
        if (isSystemInDarkTheme()) MaterialTheme.colorScheme.onBackground else ratingTextColor(movie.voteAverage)

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .padding(spacingMedium)
            .clickable {
                //todo add detail flow via API
                //navController.navigate("detail/${movie.id}")
            }
    ) {
        GlideImage(
            model = movie.coverImage,
            contentDescription = null,//todo add some content description
            modifier = Modifier
                .size(width = 232.dp, height = 262.dp)
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Text(
            text = movie.title,
            modifier = Modifier.padding(top = spacingMedium),
            style = MaterialTheme.typography.labelLarge,
            fontSize = fontXLarge,
            color = MaterialTheme.colorScheme.onBackground
        )

        if (isSystemInDarkTheme()) {
            Text(
                text = getMainMovieGender(movie.mainGenre, context),
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        } else {
            Text(
                text = getMainMovieGender(movie.mainGenre, context),
                color = Color.White,
                modifier = Modifier
                    .background(color = ueRed, shape = RoundedCornerShape(6.dp))
                    .padding(horizontal = 4.dp, vertical = 2.dp),
                fontWeight = FontWeight.Bold,
                fontSize = fontSmall
            )
        }

        Text(
            text = movie.releaseYear,
            color = MaterialTheme.colorScheme.onBackground
        )

        Text(
            text = stringResource(R.string.rating_label, movie.voteAverage),
            color = ratingTexColor
        )
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
