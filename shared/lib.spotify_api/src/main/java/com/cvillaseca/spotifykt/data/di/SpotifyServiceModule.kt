package com.cvillaseca.spotifykt.data.di

import com.cvillaseca.spotifykt.data.SpotifyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit

@Module
@InstallIn(ApplicationComponent::class)
object SpotifyServiceModule {
    @Provides
    internal fun providesSpotifyService(retrofit: Retrofit) =
        retrofit.create(SpotifyApi::class.java)
}
