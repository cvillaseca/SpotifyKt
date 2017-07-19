package com.cvillaseca.spotifykt.presentation.mvp.presenter

import android.content.Context
import android.view.View
import com.cvillaseca.spotifykt.app.base.presentation.mvp.presenter.PaginatorPresenter
import com.cvillaseca.spotifykt.data.entity.request.SearchRequest
import com.cvillaseca.spotifykt.data.manager.NetworkManager
import com.cvillaseca.spotifykt.domain.dto.ArtistDto
import com.cvillaseca.spotifykt.domain.interactor.artist.SearchArtists
import com.cvillaseca.spotifykt.presentation.mapper.ArtistDtoModelMapper
import com.cvillaseca.spotifykt.presentation.mvp.Navigator
import com.cvillaseca.spotifykt.presentation.mvp.model.ArtistModel
import com.cvillaseca.spotifykt.presentation.mvp.view.ArtistListView
import com.cvillaseca.spotifykt.presentation.ui.activity.ArtistListActivity
import io.reactivex.annotations.NonNull
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class ArtistListPresenter @Inject
constructor(networkManager: NetworkManager,
            navigator: Navigator,
            private val getArtists: SearchArtists,
            private val artistDtoModelMapper: ArtistDtoModelMapper) : PaginatorPresenter<ArtistListView>(networkManager, navigator) {
    private var lastSearch = "AC"

    override fun onViewAttached() {
        super.onViewAttached()
        refreshData()
    }

    override fun onViewDetached() {
        super.onViewDetached()
        getArtists.unsubscribe()
    }

    override fun refreshData() {
        view?.showProgress()
        loadNextPage(0)
    }

    override fun loadNextPage(itemCount: Int) {

        val searchRequest = SearchRequest(query = lastSearch,offset = itemCount, limit = 20)

        getArtists.execute(searchRequest, object : DisposableObserver<List<ArtistDto>>() {
            override fun onNext(@NonNull artistDtos: List<ArtistDto>) {
                view?.hideProgress()
                val artistModels = artistDtoModelMapper.map2(artistDtos)
                if (itemCount == 0) {
                    view?.renderArtists(artistModels)
                } else {
                    view?.appendArtists(artistModels)
                }
            }

            override fun onError(@NonNull e: Throwable) {
                view?.hideProgress()
            }

            override fun onComplete() {
                view?.hideProgress()
            }
        })
    }

    fun search(searchText: String) {

        if (!getArtists.isUnsubscribed) {
            getArtists.unsubscribe()
        }


        if (lastSearch != searchText) {
            view?.resetPagination()
        }
        lastSearch = searchText
        loadNextPage(0)
    }

    fun goToArtist(context: Context, artist: ArtistModel) {
//        navigator.goToArtist(context, artist)
    }

    fun goToArtistAnimated(artistListActivity: ArtistListActivity, view1: View, artistModel: ArtistModel) {
        navigator.goToArtistAnimated(artistListActivity, artistModel, view1)
    }
}