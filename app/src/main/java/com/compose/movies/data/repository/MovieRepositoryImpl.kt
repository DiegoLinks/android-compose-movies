package com.compose.movies.data.repository

import com.compose.movies.data.remote.ApiService
import com.compose.movies.data.model.PopularMovieResponse
import javax.inject.Inject
import retrofit2.Response

class MovieRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : MovieRepository {

    override suspend fun getPopularMovies(apiKey: String): Response<PopularMovieResponse> {
        return apiService.getPopularMovies(apiKey)
    }
}