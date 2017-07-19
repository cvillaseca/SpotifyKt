package com.cvillaseca.spotifykt.domain.repository

import com.cvillaseca.spotifykt.data.entity.request.SearchRequest
import com.cvillaseca.spotifykt.domain.Messenger
import com.cvillaseca.spotifykt.domain.dto.ArtistDto
import io.reactivex.Observable

interface ArtistRepository : Repository {
    fun searchArtists(searchRequest: SearchRequest, messenger: Messenger): Observable<List<ArtistDto>>
}