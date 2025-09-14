package com.tech.modularization

import androidx.datastore.core.Serializer
import com.tech.modularization.storage.User
import java.io.InputStream
import java.io.OutputStream

object UserSerializer : Serializer<User> {

    override val defaultValue: User = User.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): User {
        return User.parseFrom(input)
    }

    override suspend fun writeTo(
        t: User,
        output: OutputStream,
    ) {
        t.writeTo(output)
    }
}