package com.cvillaseca.spotifykt.app.base.presentation.mvp.presenter

interface PresenterFactory<out PRESENTER: BasePresenter<*>> {
    fun create(): PRESENTER
}
