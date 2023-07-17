package com.compose.movies.presentation.utils

enum class MovieGenre(val id: Int) {
    DEFAULT(0),
    ACTION(28),
    ADVENTURE(12),
    ANIMATION(16),
    COMEDY(35),
    CRIME(80),
    DOCUMENTARY(99),
    DRAMA(18),
    FAMILY(10751),
    FANTASY(14),
    HISTORY(36),
    HORROR(27),
    MUSIC(10402),
    MYSTERY(9648),
    ROMANCE(10749),
    SCIENCE_FICTION(878),
    TV_MOVIE(10770),
    THRILLER(53),
    WAR(10752),
    WESTERN(37);

    companion object {
        fun getGenreById(id: Int): MovieGenre {
            val genre = values().find { it.id == id }
            return genre ?: DEFAULT
        }
    }
}
