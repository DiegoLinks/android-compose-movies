package com.compose.movies.presentation.utils


object MovieUtils {
    fun getReleaseYear(releaseDate: String?): String {
        return releaseDate?.substring(0, 4) ?: ""
    }
}