package com.cvillaseca.spotifykt.network.di

import com.cvillaseca.spotifykt.network.NetworkConstants
import com.cvillaseca.spotifykt.network.auth.OAuthService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [OkHttpModule::class])
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun providesOAuthService(
        @OAuthOkHttp okHttpClient: OkHttpClient
    ): OAuthService =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(NetworkConstants.API_AUTH_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(OAuthService::class.java)

    @Provides
    @Singleton
    internal fun providesRetrofit(
        @ApiOkHttp okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(NetworkConstants.API_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
}
