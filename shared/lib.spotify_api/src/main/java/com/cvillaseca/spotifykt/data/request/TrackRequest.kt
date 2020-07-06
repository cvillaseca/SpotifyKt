package com.cvillaseca.spotifykt.data.request

data class TrackRequest(
    val albumId: String,
    override var offset: Int,
    override var limit: Int?
) : PaginationRequest(offset, limit)
