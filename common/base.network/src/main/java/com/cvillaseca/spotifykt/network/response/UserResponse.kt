package com.cvillaseca.spotifykt.network.response

import java.util.Date

data class UserResponse(
    var id: String,
    var username: String,
    var registerDate: Date?
)
