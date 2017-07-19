package com.cvillaseca.spotifykt.data.network.spotify

import com.google.gson.GsonBuilder
import com.cvillaseca.spotifykt.app.Constants
import com.cvillaseca.spotifykt.data.network.spotify.auth.TokenAuthenticator
import com.cvillaseca.spotifykt.data.network.spotify.interceptor.AuthInterceptor
import com.cvillaseca.spotifykt.data.store.cache.RealmTokenCache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SpotifyRestAdapter @Inject
constructor(tokenCache:RealmTokenCache) {
    val rxRetrofit: Retrofit
        get

    val retrofit: Retrofit
        get

    val authenticator = TokenAuthenticator()
    val authInterceptor = AuthInterceptor()

    init {

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
                .connectTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
                .readTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
                .authenticator(authenticator)
                .addInterceptor(authInterceptor)
                .addInterceptor(loggingInterceptor)
                .build()

        rxRetrofit = Retrofit.Builder()
                .baseUrl(Constants.API_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()

        val authClient = OkHttpClient.Builder()
                .connectTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
                .readTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build()

        retrofit = Retrofit.Builder()
                .baseUrl(Constants.API_AUTH_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .client(authClient)
                .build()

        authenticator.spotifyApi = retrofit.create(SpotifyApi::class.java)
        authenticator.tokenCache = tokenCache
        authInterceptor.tokenCache = tokenCache
    }

    companion object {
        private val TIMEOUT = 15
    }
}
