package com.cvillaseca.spotifykt.data.response

import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("href")
    val href: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("icons")
    val icons: List<Icon>
)
