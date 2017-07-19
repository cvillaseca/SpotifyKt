package com.cvillaseca.spotifykt.app.base.presentation.mvp.presenter

import com.cvillaseca.spotifykt.app.base.presentation.mvp.view.View
import com.cvillaseca.spotifykt.data.manager.NetworkManager
import com.cvillaseca.spotifykt.presentation.mvp.Navigator

abstract class BasePresenter<VIEW : View>(protected var networkManager: NetworkManager,
                                          protected var navigator: Navigator) {

    protected var view: VIEW? = null

    fun attachView(view: VIEW) {
        this.view = view
        onViewAttached()

        networkManager.add(toString(), object :NetworkManager.Listener {
            override fun onNetworkAvailable() {
                this@BasePresenter.refreshData()
            }
        })
    }

    fun detachView() {
        networkManager.remove(toString())
        onViewDetached()
        this.view = null
    }

    fun resume() {}

    fun pause() {}

    fun destroy() {
        onDestroyed()
    }

    protected open fun onViewAttached() {}

    protected open fun onViewDetached() {}

    protected fun onDestroyed() {}

    abstract fun refreshData()

}