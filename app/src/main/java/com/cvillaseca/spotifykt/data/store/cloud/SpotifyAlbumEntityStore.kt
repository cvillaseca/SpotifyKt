package com.cvillaseca.spotifykt.data.store.cloud

import com.cvillaseca.spotifykt.data.entity.AlbumEntity
import com.cvillaseca.spotifykt.data.entity.Albums
import com.cvillaseca.spotifykt.data.entity.SearchResponse
import com.cvillaseca.spotifykt.data.network.spotify.SpotifyApi
import com.cvillaseca.spotifykt.data.store.AlbumEntityStore
import io.reactivex.Observable
import javax.inject.Inject

class SpotifyAlbumEntityStore @Inject
constructor(private val spotifyApi: SpotifyApi) : AlbumEntityStore {

    override fun getAlbum(albumId: String): Observable<AlbumEntity> {
        try {
            val observable = spotifyApi.album(albumId)
            return observable
        } catch (e: Exception) {
            e.printStackTrace()
            return Observable.error(e)
        }

    }

    override fun getAlbumsByArtist(artistId: String): Observable<Albums> {
        try {
            val observable = spotifyApi.albums(artistId, 0, 20)
            return observable
        } catch (e: Exception) {
            e.printStackTrace()
            return Observable.error(e)
        }

    }

    override fun searchAlbumsByName(name: String): Observable<SearchResponse> {
        try {
            val observable = spotifyApi.search(name, 0, 20, "album", "ES")
            return observable
        } catch (e: Exception) {
            e.printStackTrace()
            return Observable.error(e)
        }

    }
}
