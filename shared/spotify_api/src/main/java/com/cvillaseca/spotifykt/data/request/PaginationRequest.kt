package com.cvillaseca.spotifykt.data.request

open class PaginationRequest(
    open val offset: Int,
    open val limit: Int? = 20
)
