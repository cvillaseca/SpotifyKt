package com.cvillaseca.spotifykt.data.entity

import com.google.gson.annotations.SerializedName

class SearchResponse {

    @SerializedName("artists")
    internal var artists: Artists? = null
        get
        set
    @SerializedName("albums")
    internal var albums: Albums? = null
        get
        set
    @SerializedName("tracks")
    internal var tracks: Tracks? = null
        get
        set
}