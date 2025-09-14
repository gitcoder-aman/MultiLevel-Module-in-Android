package com.tech.modularization.di

import com.tech.modularization.BuildConfig
import com.tech.modularization.DataStoreSessionHandler
import com.tech.modularization.network.MyAppHttpClientBuilder
import com.tech.modularization.network.RequestHandler
import com.tech.modularization.storage.SessionHandler
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
    fun provideSessionHandler(dataStoreSessionHandler: DataStoreSessionHandler) : SessionHandler = dataStoreSessionHandler

    @Provides
    fun provideHttpClient(sessionHandler: SessionHandler): HttpClient  =
        MyAppHttpClientBuilder(sessionHandler = sessionHandler)
            .protocol(URLProtocol.HTTP)
            .host(BuildConfig.MY_APP_HOST)
            .port(8080)
            .build()

    @Provides
    fun provideRequestHandler(httpClient: HttpClient) : RequestHandler = RequestHandler(httpClient)
}