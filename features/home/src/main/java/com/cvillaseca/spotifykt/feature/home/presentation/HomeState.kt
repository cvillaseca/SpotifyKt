package com.cvillaseca.spotifykt.feature.home.presentation

import android.net.Uri
import androidx.annotation.StringRes
import androidx.compose.runtime.Immutable
import com.cvillaseca.spotifykt.presentation.state.StringResource

@Immutable
data class HomeState(
    val isLoading: Boolean = false,
    val featured: Section? = null,
    val categories: Section? = null,
    val newReleases: Section? = null
)

data class Section(
    val name: StringResource,
    val items: List<Item>
)

data class Item(
    val id: String,
    val name: String,
    val image: String?
)

interface HomeAction {
    fun onSearchClick()
    fun onFeatureClick()
    fun onCategoryClick()
    fun onNewReleaseClick()
}

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
