package com.cvillaseca.spotifykt.presentation.di.module

import com.cvillaseca.spotifykt.data.network.spotify.SpotifyApi
import com.cvillaseca.spotifykt.data.network.spotify.SpotifyRestAdapter
import com.cvillaseca.spotifykt.data.store.AlbumEntityStore
import com.cvillaseca.spotifykt.data.store.ArtistEntityStore
import com.cvillaseca.spotifykt.data.store.TrackEntityStore
import com.cvillaseca.spotifykt.data.store.cache.RealmTokenCache
import com.cvillaseca.spotifykt.data.store.cloud.SpotifyAlbumEntityStore
import com.cvillaseca.spotifykt.data.store.cloud.SpotifyArtistEntityStore
import com.cvillaseca.spotifykt.data.store.cloud.SpotifyTrackEntityStore
import com.cvillaseca.spotifykt.presentation.di.scope.AppScope
import dagger.Module
import dagger.Provides

@Module
class EntityStoreModule {

    @Provides
    @AppScope
    internal fun providesArtistEntityStore(tokenCache: RealmTokenCache): ArtistEntityStore {
        val spotifyRestAdapter = SpotifyRestAdapter(tokenCache)
        val spotifyApi = spotifyRestAdapter.rxRetrofit.create(SpotifyApi::class.java)
        return SpotifyArtistEntityStore(spotifyApi)
    }

    @Provides
    @AppScope
    internal fun providesAlbumEntityStore(tokenCache: RealmTokenCache): AlbumEntityStore {
        val spotifyRestAdapter = SpotifyRestAdapter(tokenCache)
        val spotifyApi = spotifyRestAdapter.rxRetrofit.create(SpotifyApi::class.java)
        return SpotifyAlbumEntityStore(spotifyApi)
    }

    @Provides
    @AppScope
    internal fun providesTrackEntityStore(tokenCache: RealmTokenCache): TrackEntityStore {
        val spotifyRestAdapter = SpotifyRestAdapter(tokenCache)
        val spotifyApi = spotifyRestAdapter.rxRetrofit.create(SpotifyApi::class.java)
        return SpotifyTrackEntityStore(spotifyApi)
    }
}
