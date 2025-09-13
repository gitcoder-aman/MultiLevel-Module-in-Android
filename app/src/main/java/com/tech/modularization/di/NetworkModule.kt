package com.tech.modularization.di

import com.tech.modularization.BuildConfig
import com.tech.modularization.network.MyAppHttpClientBuilder
import com.tech.modularization.network.RequestHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.http.URLProtocol

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideHttpClient(): HttpClient  =
        MyAppHttpClientBuilder()
            .protocol(URLProtocol.HTTP)
            .host(BuildConfig.MY_APP_HOST)
            .build()

    @Provides
    fun provideRequestHandler(httpClient: HttpClient) : RequestHandler = RequestHandler(httpClient)
}