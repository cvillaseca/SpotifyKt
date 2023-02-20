package com.cvillaseca.spotifykt.presentation.state

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

sealed class StringResource {
    data class Id(
        @StringRes val id: Int
    ): StringResource()

    data class Raw(
        val string: String
    ): StringResource()
}

@Composable
fun StringResource.resolve(): String {
    return when(this) {
        is StringResource.Id -> stringResource(id = id)
        is StringResource.Raw -> string
    }
}
