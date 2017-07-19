package com.cvillaseca.spotifykt.data.entity

import com.google.gson.annotations.SerializedName

class TopTracksResponse {
    @SerializedName("tracks")
    internal var tracks: List<TrackEntity>? = null
    get
    set
}