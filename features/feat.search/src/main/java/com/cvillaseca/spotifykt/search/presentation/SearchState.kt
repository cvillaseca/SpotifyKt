package com.cvillaseca.spotifykt.login.presentation

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized

data class SearchState(
    val loggedIn: Async<Unit> = Uninitialized,
    val hasTripsNotifications: Boolean = false,
    val hasHostNotifications: Boolean = false
) : MvRxState
