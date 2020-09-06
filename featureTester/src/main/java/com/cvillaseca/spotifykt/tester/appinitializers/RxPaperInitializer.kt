package com.cvillaseca.spotifykt.tester.appinitializers

import android.app.Application
import com.cvillaseca.spotifykt.cache.CacheLibrary
import com.cvillaseca.spotifykt.tester.appinitializers.AppInitializer
import javax.inject.Inject

class RxPaperInitializer @Inject constructor() : AppInitializer {
    override fun init(application: Application) {
        CacheLibrary.init(application)
    }
}
