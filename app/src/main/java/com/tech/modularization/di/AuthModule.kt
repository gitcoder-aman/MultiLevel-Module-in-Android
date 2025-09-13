package com.tech.modularization.di

import com.tech.modularization.auth.data.AuthRepository
import com.tech.modularization.auth.data.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class AuthModule {

    @Provides
    fun provideAuthRepository(impl : AuthRepositoryImpl) : AuthRepository = impl


}