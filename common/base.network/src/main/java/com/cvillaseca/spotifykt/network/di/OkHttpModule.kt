package com.cvillaseca.spotifykt.network.di

import android.content.Context
import com.cvillaseca.spotifykt.network.auth.NetworkAuthenticator
import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.cvillaseca.spotifykt.network.auth.interceptor.AuthInterceptor
import com.facebook.flipper.android.AndroidFlipperClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class OkHttpModule {

    @Provides
    @Singleton
    @ApiOkHttp
    fun providesOkHttpClient(
        @ApplicationContext context: Context,
        authenticationInterceptor: AuthInterceptor,
        networkAuthenticator: NetworkAuthenticator
    ): OkHttpClient {

        // Install an HTTP cache in the application cache directory.
        val cacheDir = File(context.cacheDir, "http")
        val cache = Cache(cacheDir, DISK_CACHE_SIZE.toLong())

        val builder = OkHttpClient.Builder()
            .connectTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
            .readTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
            .writeTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
            .followRedirects(true)
            .followSslRedirects(true)
            .addInterceptor(buildLoggingInterceptor())
            .authenticator(networkAuthenticator)
            .addInterceptor(authenticationInterceptor)
            .addNetworkInterceptor(
                FlipperOkhttpInterceptor(
                    AndroidFlipperClient.getInstance(context).getPlugin(NetworkFlipperPlugin.ID)
                )
            )
            .cache(cache)

        return builder.build()
    }

    @Provides
    @Singleton
    @OAuthOkHttp
    fun providesOkHttpOauthClient(
        @ApplicationContext context: Context
    ): OkHttpClient {

        // Install an HTTP cache in the application cache directory.
        val cacheDir = File(context.cacheDir, "http")
        val cache = Cache(cacheDir, DISK_CACHE_SIZE.toLong())

        val builder = OkHttpClient.Builder()
            .connectTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
            .readTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
            .writeTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
            .followRedirects(true)
            .followSslRedirects(true)
            .addInterceptor(buildLoggingInterceptor())
            .addNetworkInterceptor(
                FlipperOkhttpInterceptor(
                    AndroidFlipperClient.getInstance(context).getPlugin(NetworkFlipperPlugin.ID)
                )
            )
            .cache(cache)

        return builder.build()
    }

    private fun buildLoggingInterceptor(): Interceptor =
        HttpLoggingInterceptor().also {
            it.level = HttpLoggingInterceptor.Level.BODY
        }

    companion object {
        private const val DISK_CACHE_SIZE = 50 * 1024 * 1024 // 50MB
        private const val TIME_OUT_SECONDS = 25L
    }
}

@Qualifier
annotation class OAuthOkHttp

@Qualifier
annotation class ApiOkHttp
