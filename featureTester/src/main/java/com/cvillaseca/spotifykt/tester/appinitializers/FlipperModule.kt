package com.cvillaseca.spotifykt.tester.appinitializers

import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object FlipperModule {

    @Provides
    fun providesFlipperNetworkPlugin(): NetworkFlipperPlugin = NetworkFlipperPlugin()
}
