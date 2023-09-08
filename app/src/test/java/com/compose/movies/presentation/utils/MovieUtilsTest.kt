package com.compose.movies.presentation.utils

import android.content.Context
import com.compose.movies.presentation.ui.theme.grassGreen
import com.compose.movies.presentation.ui.theme.lemonYellow
import com.compose.movies.presentation.ui.theme.orange
import com.compose.movies.presentation.ui.theme.ueRed
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.anyInt
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieUtilsTest {

    @Mock
    private lateinit var mockContext: Context

    @Before
    fun setup() {
        mockContext = mock(Context::class.java)
    }

    @Test
    fun testGetReleaseYear() {
        // Arrange
        val releaseDate = "2023-07-19"

        // Act
        val releaseYear = MovieUtils.getReleaseYear(releaseDate)

        // Assert
        assertEquals("2023", releaseYear)
    }

    @Test
    fun testGetReleaseYearWithNullReleaseDate() {
        // Arrange
        val releaseDate: String? = null

        // Act
        val releaseYear = MovieUtils.getReleaseYear(releaseDate)

        // Assert
        assertEquals("", releaseYear)
    }

    @Test
    fun testGetMainMovieGenderId() {
        // Arrange
        val genreIds = listOf(1, 2, 3)

        // Act
        val mainGenreId = MovieUtils.getMainMovieGenderId(genreIds)

        // Assert
        assertEquals(1, mainGenreId)
    }

    @Test
    fun testGetMainMovieGenderIdWithEmptyGenreIds() {
        // Arrange
        val genreIds: List<Int> = emptyList()

        // Act
        val mainGenreId = MovieUtils.getMainMovieGenderId(genreIds)

        // Assert
        assertEquals(0, mainGenreId)
    }

    @Test
    fun testGetMainMovieGender() {
        // Arrange
        val genreId = 28
        val expectedGenre = "Action"
        `when`(mockContext.getString(anyInt())).thenReturn("Action")

        // Act
        val mainGenre = MovieUtils.getMainMovieGender(genreId, mockContext)

        // Assert
        assertEquals(expectedGenre, mainGenre)
    }

    @Test
    fun testRatingTextColor() {
        // Arrange & Act
        val color1 = MovieUtils.ratingTextColor(8.0)
        val color2 = MovieUtils.ratingTextColor(6.0)
        val color3 = MovieUtils.ratingTextColor(3.0)
        val color4 = MovieUtils.ratingTextColor(1.0)

        // Assert
        assertEquals(grassGreen, color1)
        assertEquals(lemonYellow, color2)
        assertEquals(orange, color3)
        assertEquals(ueRed, color4)
    }
}