package com.compose.movies.presentation.utils

import org.junit.Assert.assertEquals
import org.junit.Test

class MovieGenreTest {

    @Test
    fun `getGenreById should return DEFAULT for unknown id`() {
        // Arrange
        val unknownId = -1

        // Act
        val result = MovieGenre.getGenreById(unknownId)

        // Assert
        assertEquals(MovieGenre.DEFAULT, result)
    }

    @Test
    fun `getGenreById should return DEFAULT for zero id`() {
        // Arrange
        val zeroId = 0

        // Act
        val result = MovieGenre.getGenreById(zeroId)

        // Assert
        assertEquals(MovieGenre.DEFAULT, result)
    }

    @Test
    fun `getGenreById should return correct genre for valid id`() {
        // Arrange
        val actionId = 28
        val adventureId = 12
        val animationId = 16
        val comedyId = 35
        val crimeId = 80
        val documentaryId = 99
        val dramaId = 18
        val familyId = 10751
        val fantasyId = 14
        val historyId = 36
        val horrorId = 27
        val musicId = 10402
        val mysteryId = 9648
        val romanceId = 10749
        val scienceFictionId = 878
        val tvMovieId = 10770
        val thrillerId = 53
        val warId = 10752
        val westernId = 37

        // Act
        val resultAction = MovieGenre.getGenreById(actionId)
        val resultAdventure = MovieGenre.getGenreById(adventureId)
        val resultAnimation = MovieGenre.getGenreById(animationId)
        val resultComedy = MovieGenre.getGenreById(comedyId)
        val resultCrime = MovieGenre.getGenreById(crimeId)
        val resultDocumentary = MovieGenre.getGenreById(documentaryId)
        val resultDrama = MovieGenre.getGenreById(dramaId)
        val resultFamily = MovieGenre.getGenreById(familyId)
        val resultFantasy = MovieGenre.getGenreById(fantasyId)
        val resultHistory = MovieGenre.getGenreById(historyId)
        val resultHorror = MovieGenre.getGenreById(horrorId)
        val resultMusic = MovieGenre.getGenreById(musicId)
        val resultMystery = MovieGenre.getGenreById(mysteryId)
        val resultRomance = MovieGenre.getGenreById(romanceId)
        val resultScienceFiction = MovieGenre.getGenreById(scienceFictionId)
        val resultMovie = MovieGenre.getGenreById(tvMovieId)
        val resultThriller = MovieGenre.getGenreById(thrillerId)
        val resultWar = MovieGenre.getGenreById(warId)
        val resultWestern = MovieGenre.getGenreById(westernId)

        // Assert
        assertEquals(MovieGenre.ACTION, resultAction)
        assertEquals(MovieGenre.ADVENTURE, resultAdventure)
        assertEquals(MovieGenre.ANIMATION, resultAnimation)
        assertEquals(MovieGenre.COMEDY, resultComedy)
        assertEquals(MovieGenre.CRIME, resultCrime)
        assertEquals(MovieGenre.DOCUMENTARY, resultDocumentary)
        assertEquals(MovieGenre.DRAMA, resultDrama)
        assertEquals(MovieGenre.FAMILY, resultFamily)
        assertEquals(MovieGenre.FANTASY, resultFantasy)
        assertEquals(MovieGenre.HISTORY, resultHistory)
        assertEquals(MovieGenre.HORROR, resultHorror)
        assertEquals(MovieGenre.MUSIC, resultMusic)
        assertEquals(MovieGenre.MYSTERY, resultMystery)
        assertEquals(MovieGenre.ROMANCE, resultRomance)
        assertEquals(MovieGenre.SCIENCE_FICTION, resultScienceFiction)
        assertEquals(MovieGenre.TV_MOVIE, resultMovie)
        assertEquals(MovieGenre.THRILLER, resultThriller)
        assertEquals(MovieGenre.WAR, resultWar)
        assertEquals(MovieGenre.WESTERN, resultWestern)
    }
}