package com.compose.movies.data.repository

import com.compose.movies.data.model.MovieResponse
import com.compose.movies.data.remote.ApiConstants.SORT_BY_POPULARITY
import com.compose.movies.data.remote.ApiService
import com.compose.movies.domain.model.Country
import com.compose.movies.domain.model.Movie
import com.compose.movies.presentation.utils.ImageUtils.getFullImageUrl
import com.compose.movies.presentation.utils.MovieUtils.getReleaseYear
import javax.inject.Inject

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
}