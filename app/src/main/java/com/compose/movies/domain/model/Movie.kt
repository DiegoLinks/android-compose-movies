package com.compose.movies.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val coverImage: String,
    val releaseYear: Int,
    val genre: ArrayList<String>,
    val director: String,
    val country: Country,
    val synopsis: String
)