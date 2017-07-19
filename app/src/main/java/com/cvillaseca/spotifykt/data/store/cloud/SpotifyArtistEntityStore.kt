package com.cvillaseca.spotifykt.data.store.cloud

import com.cvillaseca.spotifykt.data.entity.ArtistEntity
import com.cvillaseca.spotifykt.data.entity.SearchResponse
import com.cvillaseca.spotifykt.data.entity.request.SearchRequest
import com.cvillaseca.spotifykt.data.network.spotify.SpotifyApi
import com.cvillaseca.spotifykt.data.store.ArtistEntityStore
import io.reactivex.Observable
import javax.inject.Inject

class SpotifyArtistEntityStore @Inject
constructor(private val spotifyApi: SpotifyApi) : ArtistEntityStore {

    override fun getArtist(artistId: String): Observable<ArtistEntity> {
        try {
            val observable = spotifyApi.artist(artistId)
            return observable
        } catch (e: Exception) {
            e.printStackTrace()
            return Observable.error(e)
        }
    }

    override fun searchArtistsByName(searchRequest: SearchRequest): Observable<SearchResponse> {
        try {
            val observable = spotifyApi.search(
                    searchRequest.query,
                    searchRequest.offset,
                    searchRequest.limit,
                    "artist",
                    searchRequest.market)
            return observable
        } catch (e: Exception) {
            e.printStackTrace()
            return Observable.error(e)
        }
    }
}