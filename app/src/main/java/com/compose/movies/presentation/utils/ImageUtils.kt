package com.compose.movies.presentation.utils

object ImageUtils {
    private const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w200"

    fun getFullImageUrl(posterPath: String?): String {
        return BASE_IMAGE_URL + posterPath
    }
}