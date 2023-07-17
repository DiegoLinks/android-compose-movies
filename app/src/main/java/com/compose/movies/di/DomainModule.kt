package com.compose.movies.di

import com.compose.movies.data.repository.MovieRepository
import com.compose.movies.data.repository.MovieRepositoryImpl
import com.compose.movies.domain.usecase.GetPopularMovies
import com.compose.movies.domain.usecase.GetPopularMoviesUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindsMovieRepository(
        movieRepositoryImpl: MovieRepositoryImpl
    ): MovieRepository

    @Binds
    abstract fun bindsGetPopularMoviesUseCase(
        getPopularMovies: GetPopularMovies
    ): GetPopularMoviesUseCase
}