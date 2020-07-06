package com.cvillaseca.spotifykt.data.response

import com.google.gson.annotations.SerializedName

data class ArtistResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("genres")
    val genres: List<String>,
    @SerializedName("images")
    val images: List<Image>,
    @SerializedName("external_urls")
    val externalUrls: ExternalUrls,
    @SerializedName("followers")
    val followers: Followers,
    @SerializedName("href")
    val href: String,
    @SerializedName("popularity")
    val popularity: Int,
    @SerializedName("type")
    val type: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("uri")
    val uri: String
)
