package com.cvillaseca.spotifykt.data.store

import com.cvillaseca.spotifykt.app.base.data.store.EntityStore
import com.cvillaseca.spotifykt.data.entity.ArtistEntity
import com.cvillaseca.spotifykt.data.entity.SearchResponse
import com.cvillaseca.spotifykt.data.entity.request.SearchRequest
import io.reactivex.Observable

interface ArtistEntityStore : EntityStore {
    fun getArtist(artistId: String): Observable<ArtistEntity>
    fun searchArtistsByName(searchRequest: SearchRequest): Observable<SearchResponse>
}