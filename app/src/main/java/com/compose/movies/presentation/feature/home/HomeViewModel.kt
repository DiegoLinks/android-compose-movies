package com.compose.movies.presentation.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.movies.data.remote.NetworkResult
import com.compose.movies.domain.usecase.GetPopularMoviesUseCase
import com.compose.movies.presentation.model.MovieUI
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: GetPopularMoviesUseCase
) : ViewModel() {
    private val _movies = MutableStateFlow<List<MovieUI>>(emptyList())
    val movies: StateFlow<List<MovieUI>> = _movies

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun getMovieList(apiKey: String) {
        viewModelScope.launch {
            _isLoading.value = true
            useCase.getPopularMovies(apiKey).collect { result ->
                when (result) {
                    is NetworkResult.Success -> {
                        _movies.value = result.data ?: emptyList()
                        _isLoading.value = false
                    }
                    is NetworkResult.Error -> {
                        _error.value = result.message
                        _isLoading.value = false
                    }
                    is NetworkResult.Loading -> {
                        _isLoading.value = true
                    }
                }
            }
        }
    }
}