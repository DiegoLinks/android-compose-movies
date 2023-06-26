package com.compose.movies.presentation.feature.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.movies.data.remote.NetworkResult
import com.compose.movies.data.repository.MovieRepository
import com.compose.movies.domain.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> = _movies

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun getMovieList(apiKey: String) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val response = repository.getPopularMovies(apiKey)) {
                is NetworkResult.Success -> {
                    _movies.postValue(response.data)
                    _isLoading.postValue(false)
                }
                is NetworkResult.Error -> {
                    _error.postValue(response.message)
                    _isLoading.postValue(false)
                }
                is NetworkResult.Loading -> {
                    _isLoading.value = true
                }
            }
        }
    }
}