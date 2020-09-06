package com.cvillaseca.spotifykt.tester.di

import com.cvillaseca.spotifykt.tester.appinitializers.AppInitializer
import com.cvillaseca.spotifykt.tester.appinitializers.FlipperInitializer
import com.cvillaseca.spotifykt.tester.appinitializers.RxPaperInitializer
import com.cvillaseca.spotifykt.tester.appinitializers.TimberInitializer
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(ApplicationComponent::class)
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
