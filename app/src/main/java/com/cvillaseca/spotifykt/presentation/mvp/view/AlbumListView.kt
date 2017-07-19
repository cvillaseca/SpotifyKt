package com.cvillaseca.spotifykt.presentation.mvp.view

import com.cvillaseca.spotifykt.app.base.presentation.mvp.view.View
import com.cvillaseca.spotifykt.presentation.mvp.model.AlbumModel

interface AlbumListView : View {
    fun renderAlbums(albums: List<AlbumModel>)
    fun navigateToAlbumDetail(albumDto: AlbumModel)
}