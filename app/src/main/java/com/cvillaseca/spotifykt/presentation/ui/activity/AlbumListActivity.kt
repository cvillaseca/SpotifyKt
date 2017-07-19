package com.cvillaseca.spotifykt.presentation.ui.activity

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import butterknife.BindView
import com.cvillaseca.spotifykt.R
import com.cvillaseca.spotifykt.app.base.presentation.mvp.presenter.PresenterFactory
import com.cvillaseca.spotifykt.app.base.presentation.ui.activity.BaseDaggerActivity
import com.cvillaseca.spotifykt.presentation.di.component.ViewComponent
import com.cvillaseca.spotifykt.presentation.mvp.model.AlbumModel
import com.cvillaseca.spotifykt.presentation.mvp.model.ArtistModel
import com.cvillaseca.spotifykt.presentation.mvp.presenter.AlbumListPresenter
import com.cvillaseca.spotifykt.presentation.mvp.view.AlbumListView
import com.cvillaseca.spotifykt.presentation.mvp.view.AlbumListViewImpl
import com.cvillaseca.spotifykt.presentation.ui.adapter.AlbumsAdapter
import com.cvillaseca.spotifykt.presentation.ui.listener.EndlessScrollListener
import com.cvillaseca.spotifykt.presentation.ui.viewholder.AlbumViewHolder
import dagger.Lazy
import javax.inject.Inject

class AlbumListActivity : BaseDaggerActivity<AlbumListView, AlbumListPresenter>() {

    @Inject
    lateinit var albumListPresenter: Lazy<AlbumListPresenter>

    @BindView(R.id.artists)
    lateinit var recyclerView: RecyclerView

    private var albumsAdapter: AlbumsAdapter? = null
    private var layoutManager: LinearLayoutManager? = null
    private var scrollListener: EndlessScrollListener? = null

    override fun onLoadFinished() {
        super.onLoadFinished()
        val bundle = intent.extras
        val artist = bundle.getParcelable<ArtistModel>(ARG_ARTIST)
        presenter?.setArtist(artist)
        initUi()
    }


    override fun initView(): AlbumListView {
        return object : AlbumListViewImpl(this) {
            override fun renderAlbums(albums: List<AlbumModel>) {
                albumsAdapter?.setItems(albums)
            }

            override fun navigateToAlbumDetail(albumDto: AlbumModel) {

            }
        }
    }

    override fun presenterFactory(): PresenterFactory<AlbumListPresenter> {
        return object : PresenterFactory<AlbumListPresenter> {
            override fun create(): AlbumListPresenter {
                return albumListPresenter.get()
            }
        }
    }

    override val layout: Int
        get() = R.layout.activity_album_list

    override fun injectViewComponent(viewComponent: ViewComponent) {
        viewComponent.inject(this)
    }

    override fun onResume() {
        super.onResume()
        recyclerView.addOnScrollListener(scrollListener)
    }

    override fun onPause() {
        super.onPause()
        recyclerView.removeOnScrollListener(scrollListener)
    }

    private fun initUi() {
        initializeRecyclerView()
    }

    private fun initializeRecyclerView() {
        layoutManager = LinearLayoutManager(this)
        scrollListener = object : EndlessScrollListener(layoutManager!!) {
            override fun onLoadMore(itemsCount: Int) {
                presenter?.loadNextPage(itemsCount)
            }
        }
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(false)
        albumsAdapter = AlbumsAdapter(object : AlbumViewHolder.AlbumListener {
            override fun onClick(album: AlbumModel) {

            }
        })
        recyclerView.adapter = albumsAdapter
    }

    companion object {

        val ARG_ARTIST = "ArgArtist"
    }
}
