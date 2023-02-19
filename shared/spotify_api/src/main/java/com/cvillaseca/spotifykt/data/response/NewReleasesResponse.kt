package com.cvillaseca.spotifykt.data.response

import com.google.gson.annotations.SerializedName

data class NewReleasesResponse(
    @SerializedName("albums")
    val albums: PagedResponse<AlbumResponse>
)
