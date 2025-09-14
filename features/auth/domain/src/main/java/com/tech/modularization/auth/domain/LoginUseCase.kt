package com.tech.modularization.auth.domain

import com.tech.modularization.auth.data.AuthRepository
import com.tech.modularization.auth.data.UserLoginRequest
import com.tech.modularization.network.NetworkException
import com.tech.modularization.network.NetworkResult
import com.tech.modularization.storage.SessionHandler
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository,
    private val sessionHandler : SessionHandler,
    private val mapper : UserMapper
) {
    suspend operator fun invoke(email : String,password : String) : Resource<User>{
        val request = UserLoginRequest(email,password)

      return  when(val result = authRepository.login(request)){
            is NetworkResult.Success -> {
                sessionHandler.setCurrentUser(
                    result.result.data.id,
                    result.result.data.authToken!!
                )
                Resource.Success(mapper.map(result.result.data))
            }
            is NetworkResult.Error -> {
                result.toResourceError()
            }
        }
    }
}
