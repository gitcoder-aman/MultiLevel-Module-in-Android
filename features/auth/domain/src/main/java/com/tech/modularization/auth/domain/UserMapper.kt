package com.tech.modularization.auth.domain

import com.tech.modularization.auth.data.UserApiModel
import javax.inject.Inject

class UserMapper @Inject constructor() : Mapper<UserApiModel, User> {
    override fun map(from: UserApiModel): User {
        return User(
            id = from.id,
            fullName = from.fullName,
            email = from.email,
            createdAt = from.createAt,
            avatar = from.avatar
        )
    }

}