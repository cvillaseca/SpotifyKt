package com.cvillaseca.spotifykt.navigation.features

import android.content.Intent
import android.os.Bundle
import com.cvillaseca.spotifykt.navigation.ContainerActivity

object SearchNavigation {

    const val SEARCH_ACTIVITY_NAME = "com.cvillaseca.spotifykt.search.presentation.SearchFragment"

    @JvmStatic
    fun newIntent(): Intent = ContainerActivity.newIntent(
        SEARCH_ACTIVITY_NAME,
        Bundle()
    )
}
