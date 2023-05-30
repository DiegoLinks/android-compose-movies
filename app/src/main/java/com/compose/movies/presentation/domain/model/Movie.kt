package com.compose.movies.presentation.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val coverImage: String,
    val releaseYear: Int,
    val genre: String
)