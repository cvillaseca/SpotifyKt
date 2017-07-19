package com.cvillaseca.spotifykt.presentation.di.module

import com.cvillaseca.spotifykt.R
import com.cvillaseca.spotifykt.app.base.presentation.mvp.view.View
import com.cvillaseca.spotifykt.domain.Messenger
import com.cvillaseca.spotifykt.presentation.di.scope.ViewScope
import dagger.Module
import dagger.Provides

@Module
class ViewModule(view: View) {

    val mView = view

    @Provides
    @ViewScope
    fun providesMessenger(): Messenger {
        return object : Messenger {
            override fun showNoNetworkMessage() {

                mView.showMessage(R.string.no_internet_connection)
            }

            override fun showFromCacheMessage() {
                mView.showMessage(R.string.data_from_cache)
            }
        }
    }
}