package com.cvillaseca.spotifykt.navigation.features

import android.content.Intent
import android.os.Bundle
import com.cvillaseca.spotifykt.navigation.ContainerActivity

object LoginNavigation {

    const val LOGIN_ACTIVITY_NAME = "com.cvillaseca.spotifykt.login.presentation.LoginFragment"

    @JvmStatic
    fun newIntent(): Intent = ContainerActivity.newIntent(
        LOGIN_ACTIVITY_NAME,
        Bundle()
    )
}
