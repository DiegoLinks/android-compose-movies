package com.compose.movies.di

import com.compose.movies.data.remote.ApiService
import com.compose.movies.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object DataModule {

    @Provides
    fun providesApi(
        serviceProvider: RetrofitClient
    ) = serviceProvider.getService(ApiService::class.java)
}