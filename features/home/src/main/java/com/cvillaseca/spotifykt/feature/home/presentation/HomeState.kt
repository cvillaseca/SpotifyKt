package com.cvillaseca.spotifykt.feature.home.presentation

import android.net.Uri
import androidx.annotation.StringRes
import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.Uninitialized
import com.cvillaseca.spotifykt.feature.home.domain.HomeDomainModel

data class HomeState(
    val homeInfo: Async<HomeDomainModel> = Uninitialized
) : MavericksState

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
