package com.tech.modularization.network

sealed class NetworkResult<out T>{
    data class Success<T>(val result : T) : NetworkResult<T>()
    data class Error(val body : String?,val exception : Exception) : NetworkResult<Nothing>()
}