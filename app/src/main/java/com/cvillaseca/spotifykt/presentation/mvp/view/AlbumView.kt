package com.cvillaseca.spotifykt.presentation.mvp.view

import com.cvillaseca.spotifykt.app.base.presentation.mvp.view.View
import com.cvillaseca.spotifykt.presentation.mvp.model.AlbumModel
import com.cvillaseca.spotifykt.presentation.mvp.model.TrackModel

interface AlbumView : View {
    fun renderAlbum(albumModel: AlbumModel)

    fun renderTracks(tracks: List<TrackModel>)

    fun appendTracks(tracks: List<TrackModel>)
}