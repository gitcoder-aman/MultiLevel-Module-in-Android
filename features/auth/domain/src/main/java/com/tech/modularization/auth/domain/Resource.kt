package com.tech.modularization.auth.domain

import com.tech.modularization.network.NetworkException
import com.tech.modularization.network.NetworkResult

sealed class Resource<out T> {
    data class Success<out R>(val result: R) : Resource<R>()
    data class Error(val e: ResourceError) : Resource<Nothing>()
}
enum class ResourceError{
    UNAUTHORIZED,
    SERVICE_UNAVAILABLE,
    UNKNOWN
}

fun NetworkResult.Error.toResourceError(): Resource.Error {
    return when (this.exception) {
        is NetworkException.NotFoundException -> Resource.Error(ResourceError.SERVICE_UNAVAILABLE)
        is NetworkException.UnauthorizedException -> Resource.Error(ResourceError.UNAUTHORIZED)
        else -> Resource.Error(ResourceError.UNKNOWN)
    }
}