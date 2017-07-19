package com.cvillaseca.spotifykt.data.store.cache

import com.cvillaseca.spotifykt.data.entity.ArtistEntity
import com.cvillaseca.spotifykt.data.entity.SearchResponse
import com.cvillaseca.spotifykt.data.entity.request.SearchRequest
import io.reactivex.Observable

class RealmArtistCache : ArtistCache {

    override fun getArtist(artistId: String): Observable<ArtistEntity> {
        return Observable.empty()
    }

    override fun searchArtistsByName(searchRequest: SearchRequest): Observable<SearchResponse> {
        return Observable.empty()
    }

    override fun saveArtists(artistEntities: List<ArtistEntity>) {

    }
}