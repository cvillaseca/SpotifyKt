package com.cvillaseca.spotifykt.data.repository

import com.cvillaseca.spotifykt.app.base.data.repository.RepositoryImpl
import com.cvillaseca.spotifykt.data.entity.AlbumEntity
import com.cvillaseca.spotifykt.data.entity.Albums
import com.cvillaseca.spotifykt.data.manager.NetworkManager
import com.cvillaseca.spotifykt.data.mapper.AlbumEntityDtoMapper
import com.cvillaseca.spotifykt.data.store.AlbumEntityStore
import com.cvillaseca.spotifykt.data.store.cache.AlbumCache
import com.cvillaseca.spotifykt.domain.Messenger
import com.cvillaseca.spotifykt.domain.dto.AlbumDto
import com.cvillaseca.spotifykt.domain.repository.AlbumRepository
import io.reactivex.Observable
import javax.inject.Inject

class AlbumRepositoryImpl @Inject
constructor(networkManager: NetworkManager,
            cloudStore: AlbumEntityStore,
            cache: AlbumCache,
            albumEntityDtoMapper: AlbumEntityDtoMapper)
    : RepositoryImpl<
        AlbumEntityStore,
        AlbumCache,
        AlbumEntityDtoMapper>(networkManager, cloudStore, cache, albumEntityDtoMapper),
        AlbumRepository {

    override fun getAlbumById(albumId: String, messenger: Messenger): Observable<AlbumDto> {
        val observable: Observable<AlbumEntity>
        if (networkManager.isNetworkAvailable()) {
            observable = cloudStore.getAlbum(albumId)
        } else {
            return Observable.empty<AlbumDto>().doOnComplete {
                messenger.showNoNetworkMessage()
            }
        }

        return observable.map { albumEntity -> entityDtoMapper.map2(albumEntity) }
    }

    override fun getAlbumsByArtist(artistId: String, messenger: Messenger): Observable<List<AlbumDto>> {
        val observable: Observable<Albums>
        if (networkManager.isNetworkAvailable()) {
            observable = cloudStore.getAlbumsByArtist(artistId)
                    .doOnNext({
                        albums -> cache.saveAlbums( albums.items!!)
                    })
        } else {
            return Observable.empty<List<AlbumDto>>().doOnComplete { messenger.showNoNetworkMessage() }
        }
        return observable.map { albums -> entityDtoMapper.map2(albums.items) }
    }
}