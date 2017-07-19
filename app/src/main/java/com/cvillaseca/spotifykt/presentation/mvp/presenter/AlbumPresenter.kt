package com.cvillaseca.spotifykt.presentation.mvp.presenter

import com.cvillaseca.spotifykt.app.base.presentation.mvp.presenter.BasePresenter
import com.cvillaseca.spotifykt.data.entity.request.TrackRequest
import com.cvillaseca.spotifykt.data.manager.NetworkManager
import com.cvillaseca.spotifykt.domain.dto.TrackDto
import com.cvillaseca.spotifykt.domain.interactor.track.GetTracksByAlbum
import com.cvillaseca.spotifykt.presentation.mapper.TrackDtoModelMapper
import com.cvillaseca.spotifykt.presentation.mvp.Navigator
import com.cvillaseca.spotifykt.presentation.mvp.model.AlbumModel
import com.cvillaseca.spotifykt.presentation.mvp.view.AlbumView
import io.reactivex.annotations.NonNull
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class AlbumPresenter @Inject
constructor(networkManager: NetworkManager,
            navigator: Navigator,
            private val getTracksByAlbum: GetTracksByAlbum,
            private val trackDtoModelMapper: TrackDtoModelMapper) :
        BasePresenter<AlbumView>(networkManager, navigator) {

    private var albumModel: AlbumModel? = null

    override fun onViewAttached() {
        super.onViewAttached()
        refreshData()
    }

    override fun onViewDetached() {
        super.onViewDetached()
        getTracksByAlbum.unsubscribe()
    }

    override fun refreshData() {
        view?.renderAlbum(albumModel!!)
        view?.showProgress()

        loadNextPage(0)

    }

    fun loadNextPage(itemCount: Int) {
        val request = TrackRequest(albumModel?.id!!,itemCount, null)

        getTracksByAlbum.execute(request, object : DisposableObserver<List<TrackDto>>() {
            override fun onNext(@NonNull trackDtos: List<TrackDto>) {
                view?.hideProgress()
                val tracks = trackDtoModelMapper.map2(trackDtos)
                if (tracks.isEmpty()) {
                    return
                }
                if (itemCount == 0) {
                    view?.renderTracks(tracks)
                } else {
                    view?.appendTracks(tracks)
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

    fun setAlbumModel(albumModel: AlbumModel) {
        this.albumModel = albumModel
    }
}