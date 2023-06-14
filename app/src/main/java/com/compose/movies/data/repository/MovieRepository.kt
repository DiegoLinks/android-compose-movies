package com.compose.movies.data.repository

import com.compose.movies.data.model.PopularMovieResponse
import retrofit2.Response

interface MovieRepository {
    suspend fun getPopularMovies(apiKey: String): Response<PopularMovieResponse>
}

