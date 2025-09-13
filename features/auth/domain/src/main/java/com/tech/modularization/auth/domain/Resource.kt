package com.tech.modularization.auth.domain

sealed class Resource<out T> {
    data class Success<out R>(val result: R) : Resource<R>()
    data class Error(val e: ResourceError) : Resource<Nothing>()
}
enum class ResourceError{
    UNAUTHORIZED,
    SERVICE_UNAVAILABLE,
    UNKNOWN
}