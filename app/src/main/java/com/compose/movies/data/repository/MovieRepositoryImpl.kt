package com.compose.movies.data.repository

import com.compose.movies.data.model.MovieResponse
import com.compose.movies.data.remote.ApiConstants.SORT_BY_POPULARITY
import com.compose.movies.data.remote.ApiService
import com.compose.movies.data.remote.NetworkResult
import com.compose.movies.data.util.ErrorResponseConverter.Companion.convertErrorBody
import com.compose.movies.domain.model.Country
import com.compose.movies.domain.model.Movie
import com.compose.movies.presentation.utils.ImageUtils.getFullImageUrl
import com.compose.movies.data.util.Message.Companion.GENERIC_ERROR_MESSAGE
import com.compose.movies.presentation.utils.MovieUtils.getReleaseYear
import java.io.IOException
import javax.inject.Inject
import retrofit2.HttpException
import retrofit2.Response

class MovieRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : MovieRepository {

    override suspend fun getPopularMovies(apiKey: String): List<Movie>? {
        val sortBy = SORT_BY_POPULARITY
        return apiService.getPopularMovies(apiKey, sortBy).body()?.results?.map { it.toMovie() }
    }

    private fun MovieResponse.toMovie(): Movie {
        return Movie(
            id = id,
            title = title,
            coverImage = getFullImageUrl(posterPath),
            releaseYear = getReleaseYear(releaseDate),
            genre = arrayListOf(),
            director = "",
            country = Country("", ""),
            synopsis = overview
        )
    }

    suspend fun <T : Any> handleApi(
        execute: suspend () -> Response<T>
    ): NetworkResult<T> {
        return try {
            val response = execute()
            val body = response.body()
            if (response.isSuccessful && body != null) {
                NetworkResult.Success(body)
            } else {
                val errorMessage =
                    convertErrorBody(response.errorBody())?.message ?: GENERIC_ERROR_MESSAGE
                NetworkResult.Error(errorMessage = errorMessage)
            }
        } catch (e: HttpException) {
            NetworkResult.Error(errorMessage = e.message())
        } catch (e: IOException) {
            NetworkResult.Error(errorMessage = e.message ?: GENERIC_ERROR_MESSAGE)
        } catch (e: Throwable) {
            NetworkResult.Error(errorMessage = e.message ?: GENERIC_ERROR_MESSAGE)
        }
    }
}