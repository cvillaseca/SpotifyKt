package com.cvillaseca.spotifykt.data.repository

import com.cvillaseca.spotifykt.app.base.data.repository.RepositoryImpl
import com.cvillaseca.spotifykt.data.entity.TopTracksResponse
import com.cvillaseca.spotifykt.data.entity.Tracks
import com.cvillaseca.spotifykt.data.entity.request.TrackRequest
import com.cvillaseca.spotifykt.data.manager.NetworkManager
import com.cvillaseca.spotifykt.data.mapper.TrackEntityDtoMapper
import com.cvillaseca.spotifykt.data.store.TrackEntityStore
import com.cvillaseca.spotifykt.data.store.cache.TrackCache
import com.cvillaseca.spotifykt.domain.Messenger
import com.cvillaseca.spotifykt.domain.dto.TrackDto
import com.cvillaseca.spotifykt.domain.repository.TrackRepository
import io.reactivex.Observable
import javax.inject.Inject

class TrackRepositoryImpl @Inject
constructor(networkManager: NetworkManager,
            cloudStore: TrackEntityStore,
            cache: TrackCache,
            trackEntityDtoMapper: TrackEntityDtoMapper)
    : RepositoryImpl<TrackEntityStore, TrackCache, TrackEntityDtoMapper>(networkManager, cloudStore, cache, trackEntityDtoMapper),
        TrackRepository {


    override fun getTracksByAlbum(trackRequest: TrackRequest, messenger: Messenger): Observable<List<TrackDto>> {
        val observable: Observable<Tracks>
        if (networkManager.isNetworkAvailable()) {
            observable = cloudStore.getTracks(trackRequest)
                    .doOnNext({ tracks -> cache.saveTracksByAlbumId(tracks, trackRequest.albumId) })
        } else {
            return Observable.empty<List<TrackDto>>().doOnComplete{ messenger.showNoNetworkMessage() }
        }

        return observable.map { tracks -> entityDtoMapper.map2(tracks.items) }
    }


    override fun getTopTracks(artistId: String, messenger: Messenger): Observable<List<TrackDto>> {
        val observable: Observable<TopTracksResponse>
        if (networkManager.isNetworkAvailable()) {
            observable = cloudStore.getTopTracks(artistId)
                    .doOnNext({ tracks -> cache.saveTopTracks(tracks, artistId) })
        } else {
            return Observable.empty<List<TrackDto>>().doOnComplete { messenger.showNoNetworkMessage() }
        }

        return observable.map { tracks -> entityDtoMapper.map2(tracks.tracks) }
    }
}
