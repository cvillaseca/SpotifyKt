package com.cvillaseca.spotifykt.tester.appinitializers

import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
object FlipperModule {

    @Provides
    fun providesFlipperNetworkPlugin(): NetworkFlipperPlugin = NetworkFlipperPlugin()
}
