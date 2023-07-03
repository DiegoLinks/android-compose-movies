package com.compose.movies.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val coverImage: String?,
    val releaseYear: String,
    val genreList: ArrayList<String>,
    val mainGenre: String,
    val voteAverage: Double,
    val director: String,
    val country: Country,
    val synopsis: String
)