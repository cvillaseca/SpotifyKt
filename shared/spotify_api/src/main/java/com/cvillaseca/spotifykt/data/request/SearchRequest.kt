package com.cvillaseca.spotifykt.data.request

data class SearchRequest(
    var query: String,
    var type: String = "artist",
    var market: String = "US",
    override val offset: Int,
    override val limit: Int?
) : PaginationRequest(offset, limit)
