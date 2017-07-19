package com.cvillaseca.spotifykt.app.base.presentation.mvp.view

interface View {
    fun showMessage(message: String)

    fun showMessage(messageResId: Int)

    fun showProgress()

    fun showProgress(message: String)

    fun showProgress(messageResId: Int)

    fun showProgress(message: String, title: String)

    fun showProgress(messageResId: Int, titleResId: Int)

    fun hideProgress()

    fun hideKeyboard()
}