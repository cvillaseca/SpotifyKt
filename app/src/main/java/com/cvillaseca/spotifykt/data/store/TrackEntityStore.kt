package com.cvillaseca.spotifykt.data.store

import com.cvillaseca.spotifykt.app.base.data.store.EntityStore
import com.cvillaseca.spotifykt.data.entity.TopTracksResponse
import com.cvillaseca.spotifykt.data.entity.Tracks
import com.cvillaseca.spotifykt.data.entity.request.TrackRequest
import io.reactivex.Observable

interface TrackEntityStore : EntityStore {
    fun getTracks(trackRequest: TrackRequest): Observable<Tracks>
    fun getTopTracks(artistId: String): Observable<TopTracksResponse>
}