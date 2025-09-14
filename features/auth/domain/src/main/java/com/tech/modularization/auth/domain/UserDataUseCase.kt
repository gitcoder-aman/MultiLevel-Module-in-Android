package com.tech.modularization.auth.domain

import com.tech.modularization.auth.data.UserRepository
import com.tech.modularization.network.NetworkException
import com.tech.modularization.network.NetworkResult
import javax.inject.Inject

class UserDataUseCase @Inject constructor(
    private val userRepository: UserRepository,
    private val mapper : UserMapper
) {
    suspend fun invoke() : Resource<User>{
        return when(val result = userRepository.user()){
            is NetworkResult.Error-> result.toResourceError()
            is NetworkResult.Success-> Resource.Success(mapper.map(result.result.data))
        }
    }
}