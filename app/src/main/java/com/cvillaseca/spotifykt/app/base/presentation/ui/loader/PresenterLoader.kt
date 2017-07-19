package com.cvillaseca.spotifykt.app.base.presentation.ui.loader

import android.content.Context
import android.support.v4.content.Loader
import com.cvillaseca.spotifykt.app.base.presentation.mvp.presenter.BasePresenter
import com.cvillaseca.spotifykt.app.base.presentation.mvp.presenter.PresenterFactory

class PresenterLoader<PRESENTER: BasePresenter<*>>(
        context: Context, private val factory: PresenterFactory<PRESENTER>) : Loader<PRESENTER>(context) {

    private var presenter: PRESENTER? = null

    override fun onStartLoading() {
        if (presenter != null) {
            deliverResult(presenter)
            return
        }
        forceLoad()
    }

    override fun onForceLoad() {
        presenter = factory.create()
        deliverResult(presenter)
    }

    override fun onReset() {
        if (presenter != null) {
            presenter?.destroy()
            presenter = null
        }
    }

}