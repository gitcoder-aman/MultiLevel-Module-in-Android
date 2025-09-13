package com.tech.modularization.auth.data

import com.tech.modularization.network.NetworkResult
import com.tech.modularization.network.Response

interface AuthRepository {

    suspend fun login(request : UserLoginRequest) : NetworkResult<Response<UserApiModel>>
}