package com.cvillaseca.spotifykt.network.di

import com.cvillaseca.spotifykt.network.NetworkConstants
import com.cvillaseca.spotifykt.network.auth.OAuthService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [OkHttpModule::class])
@InstallIn(ApplicationComponent::class)
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
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
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
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
}
