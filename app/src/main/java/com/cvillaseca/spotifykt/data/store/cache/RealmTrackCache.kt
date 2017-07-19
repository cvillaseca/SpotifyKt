package com.cvillaseca.spotifykt.data.store.cache

import com.cvillaseca.spotifykt.data.entity.TopTracksResponse
import com.cvillaseca.spotifykt.data.entity.Tracks
import com.cvillaseca.spotifykt.data.entity.request.TrackRequest
import io.reactivex.Observable

class RealmTrackCache : TrackCache {

    override fun getTracks(trackRequest: TrackRequest): Observable<Tracks> {
        return Observable.empty()
    }

    override fun getTopTracks(artistId: String): Observable<TopTracksResponse> {
        return Observable.empty()
    }

    override fun saveTopTracks(tracks: TopTracksResponse, artistId: String) {

    }

    override fun saveTracksByAlbumId(tracks: Tracks, albumId: String) {

    }
}