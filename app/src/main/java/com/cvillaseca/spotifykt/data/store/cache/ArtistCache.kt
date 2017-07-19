package com.cvillaseca.spotifykt.data.store.cache

import com.cvillaseca.spotifykt.app.base.data.store.cache.Cache
import com.cvillaseca.spotifykt.data.entity.ArtistEntity
import com.cvillaseca.spotifykt.data.store.ArtistEntityStore

interface ArtistCache : ArtistEntityStore, Cache {
    fun saveArtists(artistEntities: List<ArtistEntity>)
}