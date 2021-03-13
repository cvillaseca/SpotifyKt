package com.cvillaseca.spotifykt.app.di

import com.cvillaseca.spotifykt.app.appinitializers.AppInitializer
import com.cvillaseca.spotifykt.app.appinitializers.FlipperInitializer
import com.cvillaseca.spotifykt.app.appinitializers.RxPaperInitializer
import com.cvillaseca.spotifykt.app.appinitializers.TimberInitializer
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
abstract class AppInitializersModule {

    @Binds
    @IntoSet
    abstract fun providesRxPaperInitializer(bind: RxPaperInitializer): AppInitializer

    @Binds
    @IntoSet
    abstract fun providesFlipperInitializer(bind: FlipperInitializer): AppInitializer

    @Binds
    @IntoSet
    abstract fun providesTimberInitializer(bind: TimberInitializer): AppInitializer
}
