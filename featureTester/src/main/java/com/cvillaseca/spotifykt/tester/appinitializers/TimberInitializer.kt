package com.cvillaseca.spotifykt.tester.appinitializers

import android.app.Application
import timber.log.Timber
import javax.inject.Inject

class TimberInitializer @Inject constructor() : AppInitializer {
    override fun init(application: Application) {
        Timber.plant(Timber.DebugTree())
    }
}
