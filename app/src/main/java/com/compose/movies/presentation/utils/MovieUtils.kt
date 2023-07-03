package com.compose.movies.presentation.utils


object MovieUtils {
    fun getReleaseYear(releaseDate: String?): String {
        return releaseDate?.substring(0, 4) ?: ""
    }

    fun getMainMovieGender(genreIds: List<Int>): String {
        return if (genreIds.isNotEmpty()) {
            val genreId = genreIds.first()
            return MovieGenre.getNameById(genreId)
        } else {
            ""
        }
    }
}