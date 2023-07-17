package com.compose.movies

import com.compose.movies.data.model.MovieResponse
import com.compose.movies.domain.model.Country
import com.compose.movies.domain.model.Movie

const val mockedApiKey = "YOUR_API_KEY"

val movieResponse1 = MovieResponse(
    adult = false,
    backdropPath = "",
    id = 1,
    title = "Movie 1",
    posterPath = "/path/to/poster1.jpg",
    releaseDate = "2023-01-01",
    genreIds = listOf(1, 2, 3),
    voteAverage = 7.5,
    overview = "Overview 1",
    originalLanguage = "",
    originalTitle = "",
    popularity = 10.0,
    video = false,
    voteCount = 10
)

val movieResponse2 = MovieResponse(
    adult = false,
    backdropPath = "",
    id = 2,
    title = "Movie 2",
    posterPath = "/path/to/poster2.jpg",
    releaseDate = "2023-02-01",
    genreIds = listOf(4, 5),
    voteAverage = 8.0,
    overview = "Overview 2",
    originalLanguage = "",
    originalTitle = "",
    popularity = 10.0,
    video = false,
    voteCount = 10
)

val movieResponseList = listOf(movieResponse1, movieResponse2)

val movie1 = Movie(
    id = 1,
    title = "Movie 1",
    coverImage = "/path/to/poster1.jpg",
    releaseYear = "2023",
    genreList = listOf(1, 2, 3),
    voteAverage = 7.5,
    director = "",
    country = Country("", ""),
    synopsis = "Overview 1"
)

val movie2 = Movie(
    id = 2,
    title = "Movie 2",
    coverImage = "/path/to/poster2.jpg",
    releaseYear = "2023",
    genreList = listOf(4, 5),
    voteAverage = 8.0,
    director = "",
    country = Country("", ""),
    synopsis = "Overview 2"
)

val movieList = listOf(movie1, movie2)

fun MovieResponse.toMovie(): Movie {
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