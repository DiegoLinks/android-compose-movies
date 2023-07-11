package com.compose.movies.domain.usecase

import com.compose.movies.data.remote.NetworkResult
import com.compose.movies.data.remote.NetworkResultExtensions.Companion.mapSuccess
import com.compose.movies.data.repository.MovieRepository
import com.compose.movies.domain.model.toMovieUI
import com.compose.movies.presentation.model.MovieUI
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetPopularMovies @Inject constructor(private val movieRepository: MovieRepository) :
    GetPopularMoviesUseCase {
    override suspend fun getPopularMovies(apiKey: String): Flow<NetworkResult<List<MovieUI>>> =
        flow {
            emit(NetworkResult.Loading())

            val result = movieRepository.getPopularMovies(apiKey)
                .mapSuccess { movies -> movies?.map { it.toMovieUI() } ?: emptyList() }

            emit(result)
        }
}