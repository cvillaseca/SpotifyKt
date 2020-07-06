package com.cvillaseca.spotifykt.data.response

import com.google.gson.annotations.SerializedName

data class PagedResponse<T> (
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("href")
    val href: String,
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("total")
    val total: Int,
    @SerializedName("items")
    val items: List<T>
)
