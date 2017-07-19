package com.cvillaseca.spotifykt.data.store.cache

import com.cvillaseca.spotifykt.app.base.data.store.cache.Cache
import com.cvillaseca.spotifykt.data.entity.TopTracksResponse
import com.cvillaseca.spotifykt.data.entity.Tracks
import com.cvillaseca.spotifykt.data.store.TrackEntityStore

interface TrackCache : TrackEntityStore, Cache {
    fun saveTopTracks(tracks: TopTracksResponse, artistId: String)
    fun saveTracksByAlbumId(tracks: Tracks, albumId: String)
}