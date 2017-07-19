package com.cvillaseca.spotifykt.data.entity.request

open class PaginationRequest(open var offset:Int,
                             open var limit:Int? = 20) {
}