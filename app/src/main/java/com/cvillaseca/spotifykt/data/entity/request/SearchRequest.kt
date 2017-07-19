package com.cvillaseca.spotifykt.data.entity.request

data class SearchRequest(var query: String,
                         var type: String = "artist",
                         var market: String = "ES",
                         override var offset: Int,
                         override var limit: Int?): PaginationRequest(offset, limit) {
}