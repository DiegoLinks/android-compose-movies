package com.compose.movies.domain.model

import com.compose.movies.presentation.model.MovieUI
import com.compose.movies.presentation.utils.ImageUtils
import com.compose.movies.presentation.utils.MovieUtils

data class Movie(
    val id: Int,
    val title: String,
    val coverImage: String?,
    val releaseYear: String,
    val genreList: List<Int>,
    val voteAverage: Double,
    val director: String,
    val country: Country,
    val synopsis: String
)

fun Movie.toMovieUI(): MovieUI {
    return MovieUI(
        id = id,
        title = title,
        coverImage = ImageUtils.getFullImageUrl(coverImage),
        releaseYear = MovieUtils.getReleaseYear(releaseYear),
        mainGenre = MovieUtils.getMainMovieGender(genreList),
        genreList = arrayListOf(),
        voteAverage = voteAverage,
        director = "",
        country = Country("", ""),
        synopsis = synopsis
    )
}