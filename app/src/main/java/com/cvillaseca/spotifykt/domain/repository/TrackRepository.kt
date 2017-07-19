package com.cvillaseca.spotifykt.domain.repository

import com.cvillaseca.spotifykt.data.entity.request.TrackRequest
import com.cvillaseca.spotifykt.domain.Messenger
import com.cvillaseca.spotifykt.domain.dto.TrackDto
import io.reactivex.Observable

interface TrackRepository : Repository {
    fun getTracksByAlbum(trackRequest: TrackRequest, messenger: Messenger): Observable<List<TrackDto>>
    fun getTopTracks(artistId: String, messenger: Messenger): Observable<List<TrackDto>>
}