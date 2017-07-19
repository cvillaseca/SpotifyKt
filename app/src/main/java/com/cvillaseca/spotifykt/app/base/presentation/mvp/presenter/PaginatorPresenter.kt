package com.cvillaseca.spotifykt.app.base.presentation.mvp.presenter

import com.cvillaseca.spotifykt.app.base.presentation.mvp.view.View
import com.cvillaseca.spotifykt.data.manager.NetworkManager
import com.cvillaseca.spotifykt.presentation.mvp.Navigator

abstract class PaginatorPresenter<VIEW : View>(networkManager: NetworkManager,
                                               navigator: Navigator) :
        BasePresenter<VIEW>(networkManager, navigator) {

    abstract fun loadNextPage(itemCount: Int)

}