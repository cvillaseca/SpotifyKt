package com.cvillaseca.spotifykt.data.store

import com.cvillaseca.spotifykt.app.base.data.store.EntityStore
import com.cvillaseca.spotifykt.data.entity.AlbumEntity
import com.cvillaseca.spotifykt.data.entity.Albums
import com.cvillaseca.spotifykt.data.entity.SearchResponse
import io.reactivex.Observable

interface AlbumEntityStore : EntityStore {
    fun getAlbum(albumId: String): Observable<AlbumEntity>
    fun getAlbumsByArtist(artistId: String): Observable<Albums>
    fun searchAlbumsByName(name: String): Observable<SearchResponse>
}