package com.cvillaseca.spotifykt.data.response

import com.google.gson.annotations.SerializedName

data class AlbumResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("album_type")
    val albumType: String,
    @SerializedName("artists")
    val artists: List<ArtistResponse>,
    @SerializedName("available_markets")
    val availableMarkets: List<String>,
    @SerializedName("external_urls")
    val externalUrls: ExternalUrls,
    @SerializedName("href")
    val href: String,
    @SerializedName("images")
    val images: List<Image>,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("uri")
    val uri: String
)
