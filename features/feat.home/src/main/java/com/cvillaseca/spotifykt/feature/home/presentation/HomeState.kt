package com.cvillaseca.spotifykt.feature.home.presentation

import android.net.Uri
import androidx.annotation.StringRes
import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import com.cvillaseca.spotifykt.data.response.AlbumResponse
import com.cvillaseca.spotifykt.data.response.CategoryResponse
import com.cvillaseca.spotifykt.data.response.FeaturedPlaylistsResponse

data class HomeState(
    val homeInfo: Async<HomeInfo> = Uninitialized
) : MvRxState

data class HomeInfo(
    val categories: List<CategoryResponse>,
    val newReleases: List<AlbumResponse>,
    val featuredPlaylists: FeaturedPlaylistsResponse
)

sealed class HomeSideEffect {
    data class Snackbar(
        @StringRes val error: Int
    ) : HomeSideEffect()

    data class Toast(
        @StringRes val text: Int
    ) : HomeSideEffect()

    data class Action(
        val uri: Uri
    ) : HomeSideEffect()
}
