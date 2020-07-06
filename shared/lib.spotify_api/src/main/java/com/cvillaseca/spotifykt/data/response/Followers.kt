package com.cvillaseca.spotifykt.data.response

import com.google.gson.annotations.SerializedName

data class Followers(
    @SerializedName("total")
    val total: Int,
    @SerializedName("href")
    val href: String
)
