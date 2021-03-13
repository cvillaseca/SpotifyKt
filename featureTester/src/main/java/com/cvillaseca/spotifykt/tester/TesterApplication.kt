package com.cvillaseca.spotifykt.tester

import android.app.Application
import com.cvillaseca.spotifykt.tester.appinitializers.AppInitializers
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class TesterApplication : Application() {

    @Inject
    lateinit var appInitializers: AppInitializers

    override fun onCreate() {
        super.onCreate()

        appInitializers.init(this)
    }
}
