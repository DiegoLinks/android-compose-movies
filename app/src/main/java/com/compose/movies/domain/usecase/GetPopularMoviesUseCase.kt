package com.compose.movies.domain.usecase

import com.compose.movies.data.remote.NetworkResult
import com.compose.movies.presentation.model.MovieUI
import kotlinx.coroutines.flow.Flow

interface GetPopularMoviesUseCase {
    suspend fun getPopularMovies(apiKey: String): Flow<NetworkResult<List<MovieUI>>>
}