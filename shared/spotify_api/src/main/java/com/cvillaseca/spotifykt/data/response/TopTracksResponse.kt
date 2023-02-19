package com.cvillaseca.spotifykt.data.response

import com.google.gson.annotations.SerializedName

data class TopTracksResponse(
    @SerializedName("tracks")
    val tracks: List<TrackEntity>
)
