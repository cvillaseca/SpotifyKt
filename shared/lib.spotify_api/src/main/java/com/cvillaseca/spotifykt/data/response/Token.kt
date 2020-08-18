package com.cvillaseca.spotifykt.data.response

import com.google.gson.annotations.SerializedName

data class Token(
    @SerializedName("access_token")
    var accessToken: String?,
    @SerializedName("token_type")
    var tokenType: String?,
    @SerializedName("expires_in")
    var expires: Long?
)
