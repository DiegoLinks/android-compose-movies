package com.compose.movies.domain.usecase

import com.compose.movies.data.remote.NetworkResult
import com.compose.movies.data.repository.MovieRepository
import com.compose.movies.domain.model.toMovieUI
import com.compose.movies.mockedApiKey
import com.compose.movies.movieList
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GetPopularMoviesTest {

    private val movieRepository: MovieRepository = mockk()
    private val getPopularMovies = GetPopularMovies(movieRepository)

    @Test
    fun `getPopularMovies returns loading and success`() = runTest {
        // Given
        val apiKey = mockedApiKey
        val movies = movieList//List with two movies

        coEvery { movieRepository.getPopularMovies(apiKey) } returns NetworkResult.Success(movies)

        // When
        val result = getPopularMovies.getPopularMovies(apiKey).toList()

        // Then
        val expectedResults = listOf(
            NetworkResult.Loading(),
            NetworkResult.Success(movies.map { it.toMovieUI() })
        )

        val expected1 = expectedResults[0]//Movie 1 from list
        val expected2 = expectedResults[1]//Movie 2 from list
        val result1 = result[0]//Movie 1 from list
        val result2 = result[1]//Movie 2 from list

        assertEquals(expected1.message, result1.message)
        assertEquals(expected1.data, result1.data)
        assertEquals(expected2.message, result2.message)
        assertEquals(expected2.data, result2.data)
    }

    @Test
    fun `getPopularMovies returns loading and error`() = runTest {
        // Given
        val apiKey = mockedApiKey
        val errorMessage = "Error message"
        coEvery { movieRepository.getPopularMovies(apiKey) } returns NetworkResult.Error(errorMessage)

        // When
        val result = getPopularMovies.getPopularMovies(apiKey).toList()

        // Then
        val expectedResults = listOf(
            NetworkResult.Loading<Boolean>(),
            NetworkResult.Error<String>(errorMessage)
        )

        val expected1 = expectedResults[0]
        val result1 = result[0]

        assertEquals(expected1.message, result1.message)
        assertEquals(expected1.data, result1.data)
    }
}
