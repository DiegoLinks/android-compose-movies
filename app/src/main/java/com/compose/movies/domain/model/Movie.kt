package com.compose.movies.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val coverImage: String?,
    val releaseYear: String,
    val genre: ArrayList<String>,
    val director: String,
    val country: Country,
    val synopsis: String
)