package com.cvillaseca.spotifykt.data.response

import com.google.gson.annotations.SerializedName

data class ExternalUrls(
    @SerializedName("spotify")
    val spotify: String
)
