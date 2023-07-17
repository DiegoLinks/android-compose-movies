package com.compose.movies.data.remote

import com.compose.movies.data.util.Message.Companion.GENERIC_ERROR_MESSAGE

class NetworkResultExtensions {
    companion object {
        fun <T, R> NetworkResult<T>.mapSuccess(mapper: (T?) -> R): NetworkResult<R> {
            return when (this) {
                is NetworkResult.Success -> NetworkResult.Success(mapper(data))
                is NetworkResult.Error -> NetworkResult.Error(message ?: GENERIC_ERROR_MESSAGE)
                is NetworkResult.Loading -> NetworkResult.Loading()
            }
        }
    }
}