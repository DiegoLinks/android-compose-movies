package com.compose.movies.presentation.utils

import android.content.Context
import com.compose.movies.R

object MovieUtils {
    fun getReleaseYear(releaseDate: String?): String {
        return releaseDate?.substring(0, 4) ?: ""
    }

    fun getMainMovieGenderId(genreIds: List<Int>): Int {
        return if (genreIds.isNotEmpty()) genreIds.first() else 0
    }

    fun getMainMovieGender(genreId: Int, context: Context): String {
        val mainGenre = when (MovieGenre.getGenreById(genreId)) {
            MovieGenre.ACTION -> context.getString(R.string.genre_action)
            MovieGenre.ADVENTURE -> context.getString(R.string.genre_adventure)
            MovieGenre.ANIMATION -> context.getString(R.string.genre_animation)
            MovieGenre.COMEDY -> context.getString(R.string.genre_comedy)
            MovieGenre.CRIME -> context.getString(R.string.genre_crime)
            MovieGenre.DOCUMENTARY -> context.getString(R.string.genre_documentary)
            MovieGenre.DRAMA -> context.getString(R.string.genre_drama)
            MovieGenre.FAMILY -> context.getString(R.string.genre_family)
            MovieGenre.FANTASY -> context.getString(R.string.genre_fantasy)
            MovieGenre.HISTORY -> context.getString(R.string.genre_history)
            MovieGenre.HORROR -> context.getString(R.string.genre_horror)
            MovieGenre.MUSIC -> context.getString(R.string.genre_music)
            MovieGenre.MYSTERY -> context.getString(R.string.genre_mystery)
            MovieGenre.ROMANCE -> context.getString(R.string.genre_romance)
            MovieGenre.SCIENCE_FICTION -> context.getString(R.string.genre_science_fiction)
            MovieGenre.TV_MOVIE -> context.getString(R.string.genre_tv_movie)
            MovieGenre.THRILLER -> context.getString(R.string.genre_tv_thriller)
            MovieGenre.WAR -> context.getString(R.string.genre_war)
            MovieGenre.WESTERN -> context.getString(R.string.genre_western)
            else -> context.getString(R.string.genre_default)
        }

        return mainGenre
    }
}