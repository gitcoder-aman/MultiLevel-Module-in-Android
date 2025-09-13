package com.tech.modularization.auth.data

import com.tech.modularization.network.NetworkResult
import com.tech.modularization.network.RequestHandler
import com.tech.modularization.network.Response
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val requestHandler: RequestHandler
) : AuthRepository {
    override suspend fun login(request: UserLoginRequest): NetworkResult<Response<UserApiModel>> {
        return requestHandler.post(
            urlPathSegment = listOf("auth","login"),
            body = request
        )
    }
}