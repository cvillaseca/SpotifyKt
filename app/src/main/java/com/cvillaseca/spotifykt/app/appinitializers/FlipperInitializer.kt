package com.cvillaseca.spotifykt.app.appinitializers

import android.app.Application
import android.content.IntentFilter
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.airbnb.deeplinkdispatch.DeepLinkHandler
import com.cvillaseca.spotifykt.debugtools.DebugTools
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.flipper.plugins.navigation.NavigationFlipperPlugin
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.facebook.soloader.SoLoader
import javax.inject.Inject

class FlipperInitializer @Inject constructor(
    private val networkFlipperPlugin: NetworkFlipperPlugin
) : AppInitializer {

    override fun init(application: Application) {
        SoLoader.init(application, false)
        if (DebugTools.isDebug() && FlipperUtils.shouldEnableFlipper(application)) {
            val client = AndroidFlipperClient.getInstance(application)
            client.addPlugin(NavigationFlipperPlugin.getInstance())
            client.addPlugin(InspectorFlipperPlugin(application, DescriptorMapping.withDefaults()))
            client.addPlugin(networkFlipperPlugin)
            client.start()
            LocalBroadcastManager
                .getInstance(application)
                .registerReceiver(FlipperDeepLinkReceiver(), IntentFilter(DeepLinkHandler.ACTION))
        }
    }
}
