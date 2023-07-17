package com.compose.movies.data.repository

import com.compose.movies.data.model.PopularMovieResponse
import com.compose.movies.data.remote.ApiConstants.SORT_BY_POPULARITY
import com.compose.movies.data.remote.ApiService
import com.compose.movies.data.remote.NetworkResult
import com.compose.movies.domain.model.Movie
import com.compose.movies.mockedApiKey
import com.compose.movies.movieResponseList
import com.compose.movies.toMovie
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import java.io.IOException
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody
import org.junit.Assert.assertEquals
import org.junit.Test
import retrofit2.Response
import java.net.UnknownHostException
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.HttpException

class MovieRepositoryImplTest {

    @Test
    fun `getPopularMovies should return success result when API call is successful response`() =
        runBlocking {
            // Arrange
            val apiService = mockk<ApiService>()
            val repository = MovieRepositoryImpl(apiService)
            val apiKey = mockedApiKey

            val responseList = Response.success(PopularMovieResponse(1, movieResponseList, 1, 20))
            coEvery { apiService.getPopularMovies(apiKey, SORT_BY_POPULARITY) } returns responseList

            // Act
            val expected =
                NetworkResult.Success(responseList).data?.body()?.results?.map { it.toMovie() }
                    ?: emptyList()
            val result = repository.getPopularMovies(apiKey).data

            // Assert
            coVerify { apiService.getPopularMovies(apiKey, SORT_BY_POPULARITY) }
            assertEquals(expected, result)
        }

    @Test
    fun `getPopularMovies should return error result when API call fails`() = runBlocking {
        // Arrange
        val apiService = mockk<ApiService>()
        val movieRepository = MovieRepositoryImpl(apiService)
        val apiKey = mockedApiKey
        val errorResponse =
            Response.error<PopularMovieResponse>(400, ResponseBody.create(null, "Error"))

        coEvery { apiService.getPopularMovies(apiKey, SORT_BY_POPULARITY) } returns errorResponse

        // Act
        val expected = NetworkResult.Error<List<Movie>>("An unexpected error has occurred. Please try again later.")
        val result = movieRepository.getPopularMovies(apiKey)

        // Assert
        assertEquals(expected.message, result.message)
        assertEquals(expected.data, result.data)
    }

    @Test
    fun `getPopularMovies should return error result when API call throws UnknownHostException`() =
        runBlocking {
            // Arrange
            val apiService = mockk<ApiService>()
            val movieRepository = MovieRepositoryImpl(apiService)
            val apiKey = mockedApiKey

            coEvery {
                apiService.getPopularMovies(
                    apiKey,
                    SORT_BY_POPULARITY
                )
            } throws UnknownHostException()

            // Act
            val expected =
                NetworkResult.Error<String>("No internet connection.")
            val result = movieRepository.getPopularMovies(apiKey)

            // Assert
            assertEquals(expected.message, result.message)
            assertEquals(expected.data, result.data)
        }

    @Test
    fun `getPopularMovies should return error result when API call throws HttpException`() =
        runBlocking {
            // Arrange
            val apiService = mockk<ApiService>()
            val movieRepository = MovieRepositoryImpl(apiService)
            val apiKey = mockedApiKey

            val responseError = Response.error<String>(
                400,
                ResponseBody.create("application/json".toMediaType(), "")
            )

            coEvery {
                apiService.getPopularMovies(
                    apiKey,
                    SORT_BY_POPULARITY
                )
            } throws HttpException(responseError)

            // Act
            val result = movieRepository.getPopularMovies(apiKey)

            // Assert
            assertEquals(responseError.message(), result.message)
            assertEquals(responseError.body(), result.data)
        }

    @Test
    fun `getPopularMovies should return error result when API call throws IOException`() =
        runBlocking {
            // Arrange
            val apiService = mockk<ApiService>()
            val movieRepository = MovieRepositoryImpl(apiService)
            val apiKey = mockedApiKey

            coEvery {
                apiService.getPopularMovies(
                    apiKey,
                    SORT_BY_POPULARITY
                )
            } throws IOException()

            // Act
            val expected =
                NetworkResult.Error<List<Movie>>("An unexpected error has occurred. Please try again later.")
            val result = movieRepository.getPopularMovies(apiKey)

            // Assert
            assertEquals(expected.message, result.message)
            assertEquals(expected.data, result.data)
        }

    @Test
    fun `getPopularMovies should return error result when API call throws Throwable`() =
        runBlocking {
            // Arrange
            val apiService = mockk<ApiService>()
            val movieRepository = MovieRepositoryImpl(apiService)
            val apiKey = mockedApiKey

            coEvery {
                apiService.getPopularMovies(
                    apiKey,
                    SORT_BY_POPULARITY
                )
            } throws Throwable()

            // Act
            val expected =
                NetworkResult.Error<List<Movie>>("An unexpected error has occurred. Please try again later.")
            val result = movieRepository.getPopularMovies(apiKey)

            // Assert
            assertEquals(expected.message, result.message)
            assertEquals(expected.data, result.data)
        }
}
