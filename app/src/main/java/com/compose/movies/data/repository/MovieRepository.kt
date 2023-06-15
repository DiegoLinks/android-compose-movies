package com.compose.movies.data.repository

import com.compose.movies.domain.model.Movie

interface MovieRepository {
    suspend fun getPopularMovies(apiKey: String): List<Movie>?
}

