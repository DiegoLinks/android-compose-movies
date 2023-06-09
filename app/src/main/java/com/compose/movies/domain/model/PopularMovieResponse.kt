package com.compose.movies.domain.model

import kotlinx.serialization.SerialName

class PopularMovieResponse(
    @SerialName("page") val page: Int,
    @SerialName("results") val results: List<MovieResponse>,
    @SerialName("total_pages") val totalPages: Int,
    @SerialName("total_results") val totalResults: Int
)