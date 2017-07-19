package com.cvillaseca.spotifykt.data.manager

interface NetworkManager {
    /**
     * Check network availability

     * @return true if there is network connection and false if not
     */
    fun isNetworkAvailable(): Boolean

    /**
     * Enable listening to network availability
     */
    fun start()

    /**
     * Disable listening to network availability
     */
    fun stop()

    /**
     * Add a listener to network availability

     * @param tag      unique id of a listener
     * *
     * @param listener network availability listener
     */
    fun add(tag: String, listener: Listener)

    /**
     * Remove a listener to network availability by a unique tag

     * @param tag unique id of a listener
     */
    fun remove(tag: String)

    /**
     * Network availability listener
     */
    interface Listener {

        /**
         * Is triggered when network connection appears
         */
        fun onNetworkAvailable()
    }
}