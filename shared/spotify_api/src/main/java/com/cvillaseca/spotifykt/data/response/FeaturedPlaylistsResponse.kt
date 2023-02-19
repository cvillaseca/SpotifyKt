package com.cvillaseca.spotifykt.data.response

import com.google.gson.annotations.SerializedName

data class FeaturedPlaylistsResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("playlists")
    val playlists: PagedResponse<PlaylistResponse>
)
