package com.cvillaseca.spotifykt.presentation.di.module

import com.cvillaseca.spotifykt.data.manager.NetworkManager
import com.cvillaseca.spotifykt.data.mapper.AlbumEntityDtoMapper
import com.cvillaseca.spotifykt.data.mapper.ArtistEntityDtoMapper
import com.cvillaseca.spotifykt.data.mapper.TrackEntityDtoMapper
import com.cvillaseca.spotifykt.data.repository.AlbumRepositoryImpl
import com.cvillaseca.spotifykt.data.repository.ArtistRepositoryImpl
import com.cvillaseca.spotifykt.data.repository.TrackRepositoryImpl
import com.cvillaseca.spotifykt.data.store.AlbumEntityStore
import com.cvillaseca.spotifykt.data.store.ArtistEntityStore
import com.cvillaseca.spotifykt.data.store.TrackEntityStore
import com.cvillaseca.spotifykt.data.store.cache.AlbumCache
import com.cvillaseca.spotifykt.data.store.cache.ArtistCache
import com.cvillaseca.spotifykt.data.store.cache.TrackCache
import com.cvillaseca.spotifykt.domain.repository.AlbumRepository
import com.cvillaseca.spotifykt.domain.repository.ArtistRepository
import com.cvillaseca.spotifykt.domain.repository.TrackRepository
import com.cvillaseca.spotifykt.presentation.di.scope.AppScope
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    @AppScope
    internal fun providesArtistRepository(networkManager: NetworkManager,
                                          cloudStore: ArtistEntityStore,
                                          cache: ArtistCache,
                                          artistEntityDtoMapper: ArtistEntityDtoMapper): ArtistRepository {
        return ArtistRepositoryImpl(networkManager, cloudStore, cache, artistEntityDtoMapper)
    }

    @Provides
    @AppScope
    internal fun providesAlbumRepository(networkManager: NetworkManager,
                                         cloudStore: AlbumEntityStore,
                                         cache: AlbumCache,
                                         albumEntityDtoMapper: AlbumEntityDtoMapper): AlbumRepository {
        return AlbumRepositoryImpl(networkManager, cloudStore, cache, albumEntityDtoMapper)
    }

    @Provides
    @AppScope
    internal fun providesTrackRepository(networkManager: NetworkManager,
                                         cloudStore: TrackEntityStore,
                                         cache: TrackCache,
                                         trackEntityDtoMapper: TrackEntityDtoMapper): TrackRepository {
        return TrackRepositoryImpl(networkManager, cloudStore, cache, trackEntityDtoMapper)
    }
}