package com.cvillaseca.spotifykt.app

import android.app.Application
import com.airbnb.mvrx.Mavericks
import com.cvillaseca.spotifykt.app.appinitializers.AppInitializers
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MainApplication : Application() {

    @Inject
    lateinit var appInitializers: AppInitializers

    override fun onCreate() {
        super.onCreate()
        Mavericks.initialize(this)

        appInitializers.init(this)
    }
}
