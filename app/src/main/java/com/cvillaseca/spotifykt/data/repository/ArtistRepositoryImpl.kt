package com.cvillaseca.spotifykt.data.repository

import com.cvillaseca.spotifykt.app.base.data.repository.RepositoryImpl
import com.cvillaseca.spotifykt.data.entity.SearchResponse
import com.cvillaseca.spotifykt.data.entity.request.SearchRequest
import com.cvillaseca.spotifykt.data.manager.NetworkManager
import com.cvillaseca.spotifykt.data.mapper.ArtistEntityDtoMapper
import com.cvillaseca.spotifykt.data.store.ArtistEntityStore
import com.cvillaseca.spotifykt.data.store.cache.ArtistCache
import com.cvillaseca.spotifykt.domain.Messenger
import com.cvillaseca.spotifykt.domain.dto.ArtistDto
import com.cvillaseca.spotifykt.domain.repository.ArtistRepository
import io.reactivex.Observable
import javax.inject.Inject

class ArtistRepositoryImpl @Inject
constructor(networkManager: NetworkManager,
            cloudStore: ArtistEntityStore,
            cache: ArtistCache,
            artistEntityDtoMapper: ArtistEntityDtoMapper)
    : RepositoryImpl<
        ArtistEntityStore,
        ArtistCache,
        ArtistEntityDtoMapper>(networkManager, cloudStore, cache, artistEntityDtoMapper),
        ArtistRepository {

    override fun searchArtists(searchRequest: SearchRequest, messenger: Messenger): Observable<List<ArtistDto>> {
        val observable: Observable<SearchResponse>
        if (networkManager.isNetworkAvailable()) {
            observable = cloudStore.searchArtistsByName(searchRequest)
                    .doOnNext({ artistResponse -> cache.saveArtists(artistResponse.artists?.items!!) })
        } else {
            return Observable.empty<List<ArtistDto>>().doOnComplete{ messenger.showNoNetworkMessage() }
        }

        return observable.map { artistResponse -> entityDtoMapper.map2(artistResponse.artists?.items!!) }
    }
}
