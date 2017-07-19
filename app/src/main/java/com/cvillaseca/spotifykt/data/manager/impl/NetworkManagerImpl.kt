package com.cvillaseca.spotifykt.data.manager.impl

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import com.cvillaseca.spotifykt.data.manager.NetworkManager
import java.util.HashMap

class NetworkManagerImpl constructor(context: Context): BroadcastReceiver(), NetworkManager {

    private var context: Context? = null

    private val connectivityIntentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)

    private val listeners = HashMap<String,NetworkManager.Listener>()

    init {
        this.context = context
    }

    override fun isNetworkAvailable(): Boolean {
        val cm = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        if (null != activeNetwork) {
            if (activeNetwork.type == ConnectivityManager.TYPE_WIFI || activeNetwork.type == ConnectivityManager.TYPE_MOBILE) {
                return true
            }
        }
        return false
    }

    override fun start() {
        context?.registerReceiver(this, connectivityIntentFilter)
    }

    override fun stop() {
        context?.unregisterReceiver(this)
    }

    override fun add(tag: String, listener: NetworkManager.Listener) {
        listeners.put(tag, listener)
    }

    override fun remove(tag: String) {
        listeners.remove(tag)
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        if (isNetworkAvailable()) {
            if (!isInitialStickyBroadcast) {
                for (listener in listeners.values) {
                        listener.onNetworkAvailable()
                }
            }
        }
    }
}