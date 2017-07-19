package com.cvillaseca.spotifykt.data.store.cache

import com.cvillaseca.spotifykt.app.base.data.store.cache.Cache
import com.cvillaseca.spotifykt.data.entity.AlbumEntity
import com.cvillaseca.spotifykt.data.store.AlbumEntityStore

interface AlbumCache : AlbumEntityStore, Cache {
    fun saveAlbums(albums: List<AlbumEntity>)
}