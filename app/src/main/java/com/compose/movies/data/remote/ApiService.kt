package com.compose.movies.data.remote

import com.compose.movies.data.model.PopularMovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("discover/movie")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String, @Query("sort_by") sortBy: String): Response<PopularMovieResponse>
}