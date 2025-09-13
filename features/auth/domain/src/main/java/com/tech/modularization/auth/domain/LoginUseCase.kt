package com.tech.modularization.auth.domain

import com.tech.modularization.auth.data.AuthRepository
import com.tech.modularization.auth.data.UserLoginRequest
import com.tech.modularization.network.NetworkException
import com.tech.modularization.network.NetworkResult
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository,
    private val mapper : UserMapper
) {
    suspend operator fun invoke(email : String,password : String) : Resource<User>{
        val request = UserLoginRequest(email,password)

      return  when(val result = authRepository.login(request)){
            is NetworkResult.Success -> {
                Resource.Success(mapper.map(result.result.data))
            }
            is NetworkResult.Error -> {
                result.toResourceError()
            }
        }
    }
    fun NetworkResult.Error.toResourceError(): Resource.Error {
        return when (this.exception) {
            is NetworkException.NotFoundException -> Resource.Error(ResourceError.SERVICE_UNAVAILABLE)
            is NetworkException.UnauthorizedException -> Resource.Error(ResourceError.UNAUTHORIZED)
            else -> Resource.Error(ResourceError.UNKNOWN)
        }
    }

}
