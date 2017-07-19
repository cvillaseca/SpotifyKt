package com.cvillaseca.spotifykt.app.base.presentation.ui.activity

import android.os.Bundle
import com.cvillaseca.spotifykt.app.App
import com.cvillaseca.spotifykt.app.base.presentation.mvp.presenter.BasePresenter
import com.cvillaseca.spotifykt.app.base.presentation.mvp.view.View
import com.cvillaseca.spotifykt.presentation.di.component.ViewComponent
import com.cvillaseca.spotifykt.presentation.di.module.ViewModule

abstract class BaseDaggerActivity<
        VIEW : View,
        PRESENTER : BasePresenter<VIEW>> :
        BaseActivity<PRESENTER, VIEW>() {

    private var viewComponent: ViewComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewComponent()
    }

    protected abstract fun injectViewComponent(viewComponent: ViewComponent)

    private fun initViewComponent() {
        viewComponent = (application as App).getAppComponent()
                .plus(ViewModule(view!!))
        injectViewComponent(viewComponent!!)
    }
}