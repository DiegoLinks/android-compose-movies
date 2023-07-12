package com.compose.movies.presentation.model

import com.compose.movies.domain.model.Country

data class MovieUI(
    val id: Int,
    val title: String,
    val coverImage: String?,
    val releaseYear: String,
    val genreList: ArrayList<String>?,
    val mainGenre: Int,
    val voteAverage: Double,
    val director: String,
    val country: Country,
    val synopsis: String
)