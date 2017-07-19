package com.cvillaseca.spotifykt.presentation.di.module

import com.cvillaseca.spotifykt.data.store.cache.*
import com.cvillaseca.spotifykt.presentation.di.scope.AppScope
import dagger.Module
import dagger.Provides

@Module
class CacheModule {

    @Provides
    @AppScope
    internal fun providesArtistCache(): ArtistCache {
        return RealmArtistCache()
    }

    @Provides
    @AppScope
    internal fun providesAlbumCache(): AlbumCache {
        return RealmAlbumCache()
    }

    @Provides
    @AppScope
    internal fun providesTrackCache(): TrackCache {
        return RealmTrackCache()
    }

}