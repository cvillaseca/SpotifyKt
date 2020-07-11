package com.cvillaseca.spotifykt.data.response

import com.google.gson.annotations.SerializedName

data class PlaylistResponse(
    @SerializedName("collaborative")
    val collaborative: Boolean,
    @SerializedName("description")
    val description: String?,
    @SerializedName("external_urls")
    val externalUrls: ExternalUrls,
    @SerializedName("href")
    val href: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("images")
    val images: List<Image>,
    @SerializedName("name")
    val name: String,
    @SerializedName("owner")
    val owner: UserResponse,
    @SerializedName("public")
    val public: Boolean?,
    @SerializedName("snapshot_id")
    val snapshot_id: String,
//    @SerializedName("tracks")
//    val tracks: String?,
    @SerializedName("type")
    val type: String,
    @SerializedName("uri")
    val uri: String
)
