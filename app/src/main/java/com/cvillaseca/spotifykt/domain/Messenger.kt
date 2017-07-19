package com.cvillaseca.spotifykt.domain

interface Messenger {
    /**
     * Show a message about network connection problem
     */
    fun showNoNetworkMessage()

    /**
     * Show a message that data was loaded from cache
     */
    fun showFromCacheMessage()
}