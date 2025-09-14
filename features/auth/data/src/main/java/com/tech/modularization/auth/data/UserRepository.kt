package com.tech.modularization.auth.data

import com.tech.modularization.network.NetworkResult
import com.tech.modularization.network.Response

interface UserRepository {
    suspend fun user() : NetworkResult<Response<UserApiModel>>
}