package com.cvillaseca.spotifykt.data.response

import com.google.gson.annotations.SerializedName

class SearchResponse(
    @SerializedName("artists")
    val artists: PagedResponse<ArtistResponse>,
    @SerializedName("albums")
    val albumsResponse: PagedResponse<AlbumResponse>,
    @SerializedName("tracks")
    val tracks: PagedResponse<TrackEntity>
)
