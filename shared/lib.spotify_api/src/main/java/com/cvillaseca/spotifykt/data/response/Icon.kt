package com.cvillaseca.spotifykt.data.response

import com.google.gson.annotations.SerializedName

data class Icon(
    @SerializedName("height")
    val height: Int,
    @SerializedName("width")
    val width: Int,
    @SerializedName("url")
    val url: String
)
