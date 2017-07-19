package com.cvillaseca.spotifykt.presentation.mvp.view

import com.cvillaseca.spotifykt.app.base.presentation.mvp.view.View
import com.cvillaseca.spotifykt.presentation.mvp.model.AlbumModel
import com.cvillaseca.spotifykt.presentation.mvp.model.ArtistModel
import com.cvillaseca.spotifykt.presentation.mvp.model.TrackModel

interface ArtistView : View {
    fun renderAlbums(albums: List<AlbumModel>)

    fun renderArtist(artist: ArtistModel)

    fun renderTopTracks(trackModels: List<TrackModel>)
}
