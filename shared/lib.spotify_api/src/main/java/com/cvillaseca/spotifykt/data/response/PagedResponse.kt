package com.cvillaseca.spotifykt.data.response

import com.google.gson.annotations.SerializedName

data class PagedResponse<T> (
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("href")
    val href: String,
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("total")
    val total: Int,
    @SerializedName("items")
    val items: List<T>
)
