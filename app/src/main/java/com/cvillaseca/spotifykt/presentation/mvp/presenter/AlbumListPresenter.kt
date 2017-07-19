package com.cvillaseca.spotifykt.presentation.mvp.presenter

import com.cvillaseca.spotifykt.app.base.presentation.mvp.presenter.PaginatorPresenter
import com.cvillaseca.spotifykt.data.manager.NetworkManager
import com.cvillaseca.spotifykt.domain.dto.AlbumDto
import com.cvillaseca.spotifykt.domain.interactor.album.GetAlbumsByArtist
import com.cvillaseca.spotifykt.presentation.mapper.AlbumDtoModelMapper
import com.cvillaseca.spotifykt.presentation.mvp.Navigator
import com.cvillaseca.spotifykt.presentation.mvp.model.ArtistModel
import com.cvillaseca.spotifykt.presentation.mvp.view.AlbumListView
import io.reactivex.annotations.NonNull
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class AlbumListPresenter @Inject
constructor(networkManager: NetworkManager,
            navigator: Navigator,
            private val getAlbumsByArtist: GetAlbumsByArtist,
            private val albumDtoModelMapper: AlbumDtoModelMapper) :
        PaginatorPresenter<AlbumListView>(networkManager, navigator) {

    private var artist: ArtistModel? = null

    override fun onViewAttached() {
        super.onViewAttached()
        refreshData()
    }

    override fun onViewDetached() {
        super.onViewDetached()
        getAlbumsByArtist.unsubscribe()
    }

    override fun refreshData() {
        view?.showProgress()
        getAlbumsByArtist.execute(artist!!.id!!, object : DisposableObserver<List<AlbumDto>>() {
            override fun onNext(@NonNull albumDtos: List<AlbumDto>) {
                view?.hideProgress()
                view?.renderAlbums(albumDtoModelMapper.map2(albumDtos))
            }

            override fun onError(@NonNull e: Throwable) {
                view?.hideProgress()
            }

            override fun onComplete() {
                view?.hideProgress()
            }
        })
    }

    override fun loadNextPage(itemCount: Int) {

    }

    fun setArtist(artist: ArtistModel) {
        this.artist = artist
    }


}
