package com.cvillaseca.spotifykt.network.di

// @Module
// @InstallIn(ApplicationComponent::class)
// class OkHttpModule {
//
//    @Provides
//    @Singleton
//    @ApiOkHttp
//    internal fun providesOkHttpClient(
//        context: Context,
//        authenticationInterceptor: AuthInterceptor
//    ): OkHttpClient {
//
//        // Install an HTTP cache in the application cache directory.
//        val cacheDir = File(context.cacheDir, "http")
//        val cache = Cache(cacheDir, DISK_CACHE_SIZE.toLong())
//
//        val builder = OkHttpClient.Builder()
//            .connectTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
//            .readTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
//            .writeTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
//            .followRedirects(true)
//            .followSslRedirects(true)
//            .addInterceptor(authenticationInterceptor)
//            .cache(cache)
//
//        return builder.build()
//    }
//
//    @Provides
//    @Singleton
//    @Named("oauth")
//    internal fun providesOkHttpOauthClient(
//        context: Context
//    ): OkHttpClient {
//
//        // Install an HTTP cache in the application cache directory.
//        val cacheDir = File(context.cacheDir, "http")
//        val cache = Cache(cacheDir, DISK_CACHE_SIZE.toLong())
//
//        val builder = OkHttpClient.Builder()
//            .connectTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
//            .readTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
//            .writeTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
//            .followRedirects(true)
//            .followSslRedirects(true)
//            .cache(cache)
//
//        return builder.build()
//    }
//
//    companion object {
//        private const val DISK_CACHE_SIZE = 50 * 1024 * 1024 // 50MB
//        private const val TIME_OUT_SECONDS = 25L
//    }
// }
