package com.cvillaseca.spotifykt.tester.appinitializers

import android.app.Application
import com.cvillaseca.spotifykt.tester.TesterApplication
import javax.inject.Inject

/**
 * Delegate used to isolate any application initialization.
 * Usage:
 * - Create a class implementing [AppInitializer]
 * - Add a provider in [ApplicationModule]
 *
 * Dagger will inject that class in the [initializers] set and execute it during
 * [Application.onCreate].
 */
class AppInitializers @Inject constructor(
    private val initializers: Set<@JvmSuppressWildcards AppInitializer>
) {
    fun init(application: TesterApplication) {
        initializers.forEach {
            it.init(application)
        }
    }
}
