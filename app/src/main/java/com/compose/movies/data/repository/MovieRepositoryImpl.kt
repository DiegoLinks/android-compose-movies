package com.compose.movies.data.repository

import com.compose.movies.data.model.MovieResponse
import com.compose.movies.data.remote.ApiConstants.SORT_BY_POPULARITY
import com.compose.movies.data.remote.ApiService
import com.compose.movies.data.remote.NetworkResult
import com.compose.movies.data.remote.NetworkResultExtensions.Companion.mapSuccess
import com.compose.movies.data.util.ErrorResponseConverter.Companion.convertErrorBody
import com.compose.movies.domain.model.Movie
import com.compose.movies.data.util.Message.Companion.GENERIC_ERROR_MESSAGE
import com.compose.movies.data.util.Message.Companion.NO_INTERNET_MESSAGE
import com.compose.movies.domain.model.Country
import java.io.IOException
import java.net.UnknownHostException
import javax.inject.Inject
import retrofit2.HttpException
import retrofit2.Response

class MovieRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : MovieRepository {

    override suspend fun getPopularMovies(apiKey: String): NetworkResult<List<Movie>> {
        return handleApi {
            apiService.getPopularMovies(apiKey, SORT_BY_POPULARITY)
        }.mapSuccess { response ->
            response?.results?.map { it.toMovie() } ?: emptyList()
        }
    }

    private fun MovieResponse.toMovie(): Movie {
        return Movie(
            id = id,
            title = title,
            coverImage = posterPath,
            releaseYear = releaseDate,
            genreList = genreIds,
            voteAverage = voteAverage,
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
        } catch (e: UnknownHostException) {
            NetworkResult.Error(errorMessage = NO_INTERNET_MESSAGE)
        } catch (e: HttpException) {
            NetworkResult.Error(errorMessage = e.message())
        } catch (e: IOException) {
            NetworkResult.Error(errorMessage = e.message ?: GENERIC_ERROR_MESSAGE)
        } catch (e: Throwable) {
            NetworkResult.Error(errorMessage = e.message ?: GENERIC_ERROR_MESSAGE)
        }
    }
}