package com.cvillaseca.spotifykt.data.store.cloud

import com.cvillaseca.spotifykt.data.entity.TopTracksResponse
import com.cvillaseca.spotifykt.data.entity.Tracks
import com.cvillaseca.spotifykt.data.entity.request.TrackRequest
import com.cvillaseca.spotifykt.data.network.spotify.SpotifyApi
import com.cvillaseca.spotifykt.data.store.TrackEntityStore
import io.reactivex.Observable
import javax.inject.Inject

class SpotifyTrackEntityStore @Inject
constructor(private val spotifyApi: SpotifyApi) : TrackEntityStore {

    override fun getTracks(trackRequest: TrackRequest): Observable<Tracks> {
        try {
            val observable = spotifyApi.tracks(
                    trackRequest.albumId,
                    trackRequest.offset,
                    trackRequest.limit
            )
            return observable
        } catch (e: Exception) {
            e.printStackTrace()
            return Observable.error(e)
        }

    }

    override fun getTopTracks(artistId: String): Observable<TopTracksResponse> {
        try {
            val observable = spotifyApi.topTracks(artistId, "ES")
            return observable
        } catch (e: Exception) {
            e.printStackTrace()
            return Observable.error(e)
        }

    }
}
