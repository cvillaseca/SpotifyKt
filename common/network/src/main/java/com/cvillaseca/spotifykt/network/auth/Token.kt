package com.cvillaseca.spotifykt.network.auth

import com.google.gson.annotations.SerializedName

data class Token(
    val id: String?,
    @SerializedName("access_token")
    var accessToken: String,
    @SerializedName("token_type")
    var tokenType: String,
    @SerializedName("refresh_token")
    var refreshToken: String?,
    @SerializedName("expires_in")
    var expires: Long,
    @SerializedName("scope")
    var scope: String
)
