package com.cvillaseca.spotifykt.presentation.di.component

import com.cvillaseca.spotifykt.presentation.di.module.ViewModule
import com.cvillaseca.spotifykt.presentation.di.scope.ViewScope
import com.cvillaseca.spotifykt.presentation.ui.activity.AlbumActivity
import com.cvillaseca.spotifykt.presentation.ui.activity.AlbumListActivity
import com.cvillaseca.spotifykt.presentation.ui.activity.ArtistActivity
import com.cvillaseca.spotifykt.presentation.ui.activity.ArtistListActivity
import dagger.Subcomponent

@ViewScope
@Subcomponent(modules = arrayOf(ViewModule::class))
interface ViewComponent {
    fun inject(albumListActivity: AlbumListActivity)
    fun inject(albumActivity: AlbumActivity)
    fun inject(artistListActivity: ArtistListActivity)
    fun inject(artistActivity: ArtistActivity)
}