package com.cvillaseca.spotifykt.domain.repository

import com.cvillaseca.spotifykt.domain.Messenger
import com.cvillaseca.spotifykt.domain.dto.AlbumDto
import io.reactivex.Observable

interface AlbumRepository : Repository {
    fun getAlbumById(albumId: String, messenger: Messenger): Observable<AlbumDto>
    fun getAlbumsByArtist(artistId: String, messenger: Messenger): Observable<List<AlbumDto>>
}