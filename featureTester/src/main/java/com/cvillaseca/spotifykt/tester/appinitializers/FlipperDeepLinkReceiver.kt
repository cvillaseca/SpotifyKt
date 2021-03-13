package com.cvillaseca.spotifykt.tester.appinitializers

import android.content.BroadcastReceiver
import android.content.Context
import com.facebook.flipper.plugins.navigation.NavigationFlipperPlugin
import com.airbnb.deeplinkdispatch.DeepLinkHandler
import android.content.Intent
import java.util.Date

/**
 * Registers a deeplink listener for Flipper to keep track of the navigation
 */
class FlipperDeepLinkReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val deepLinkUri = intent.getStringExtra(DeepLinkHandler.EXTRA_URI)
        if (intent.getBooleanExtra(DeepLinkHandler.EXTRA_SUCCESSFUL, false)) {
            NavigationFlipperPlugin.getInstance()
                .sendNavigationEvent(
                    deepLinkUri,
                    null,
                    Date()
                )
        }
    }
}
