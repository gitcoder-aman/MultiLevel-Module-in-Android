package com.tech.modularization.auth.data

import com.tech.modularization.network.NetworkResult
import com.tech.modularization.network.RequestHandler
import com.tech.modularization.network.Response
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val requestHandler: RequestHandler
) : UserRepository {
    override suspend fun user(): NetworkResult<Response<UserApiModel>> {
       return requestHandler.get(urlPathSegment = listOf("user"))
    }
}