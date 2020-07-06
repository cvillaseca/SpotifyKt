package com.cvillaseca.spotifykt.app.appinitializers

import android.app.Application
import javax.inject.Inject

/**
 * Empty Flipper initializer for production.
 */
class FlipperInitializer @Inject constructor() : AppInitializer {

    override fun init(application: Application) = Unit
}
