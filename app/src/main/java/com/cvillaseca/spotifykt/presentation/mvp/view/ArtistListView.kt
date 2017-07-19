package com.cvillaseca.spotifykt.presentation.mvp.view

import com.cvillaseca.spotifykt.app.base.presentation.mvp.view.View
import com.cvillaseca.spotifykt.presentation.mvp.model.ArtistModel

interface ArtistListView : View {
    fun renderArtists(artists: List<ArtistModel>)

    fun appendArtists(artists: List<ArtistModel>)

    fun resetPagination()
}