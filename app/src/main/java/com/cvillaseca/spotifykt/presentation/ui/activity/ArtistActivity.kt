package com.cvillaseca.spotifykt.presentation.ui.activity

import android.graphics.drawable.Drawable
import android.os.Build
import android.support.v4.content.ContextCompat
import android.support.v4.widget.NestedScrollView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import butterknife.BindView
import com.cvillaseca.spotifykt.R
import com.cvillaseca.spotifykt.app.base.presentation.mvp.presenter.PresenterFactory
import com.cvillaseca.spotifykt.app.base.presentation.ui.activity.BaseDaggerActivity
import com.cvillaseca.spotifykt.presentation.di.component.ViewComponent
import com.cvillaseca.spotifykt.presentation.mvp.model.AlbumModel
import com.cvillaseca.spotifykt.presentation.mvp.model.ArtistModel
import com.cvillaseca.spotifykt.presentation.mvp.model.TrackModel
import com.cvillaseca.spotifykt.presentation.mvp.presenter.ArtistPresenter
import com.cvillaseca.spotifykt.presentation.mvp.view.ArtistView
import com.cvillaseca.spotifykt.presentation.mvp.view.ArtistViewImpl
import com.cvillaseca.spotifykt.data.audio.AudioController
import com.cvillaseca.spotifykt.presentation.ui.adapter.AlbumsHorizontalAdapter
import com.cvillaseca.spotifykt.presentation.ui.adapter.TracksAdapter
import com.cvillaseca.spotifykt.presentation.ui.listener.EndlessScrollListener
import com.cvillaseca.spotifykt.presentation.ui.view.scrollview.NotifyingScrollView
import com.cvillaseca.spotifykt.presentation.ui.viewholder.AlbumViewHolder
import com.cvillaseca.spotifykt.presentation.ui.viewholder.TrackViewHolder
import com.squareup.picasso.Picasso
import dagger.Lazy
import javax.inject.Inject

class ArtistActivity : BaseDaggerActivity<ArtistView, ArtistPresenter>() {

    companion object {
        val ARG_ARTIST = "ArgArtist"
    }

    @Inject
    lateinit var audioController: AudioController

    @Inject
    lateinit var artistPresenter: Lazy<ArtistPresenter>

    @BindView(R.id.scroll_view)
    lateinit var scrollView: NotifyingScrollView

    @BindView(R.id.album_image)
    lateinit var artistImage: ImageView

    @BindView(R.id.albums)
    lateinit var albumList: RecyclerView

    @BindView(R.id.topTracks)
    lateinit var trackList: RecyclerView

    private var albumsAdapter: AlbumsHorizontalAdapter? = null
    private var tracksAdapter: TracksAdapter? = null

    private var layoutManager: LinearLayoutManager? = null
    private var scrollListener: EndlessScrollListener? = null

    private var mActionBarBackgroundDrawable: Drawable? = null

    override fun onLoadFinished() {
        super.onLoadFinished()

        initUi()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    override fun initView(): ArtistView {
        return object : ArtistViewImpl(this) {
            override fun renderAlbums(albums: List<AlbumModel>) {
                albumsAdapter?.setItems(albums)
            }

            override fun renderArtist(artist: ArtistModel) {
                Picasso.with(this@ArtistActivity).load(artist.thumbnail?.url).into(artistImage)
            }

            override fun renderTopTracks(trackModels: List<TrackModel>) {
                tracksAdapter?.setItems(trackModels)
            }
        }
    }

    override fun presenterFactory(): PresenterFactory<ArtistPresenter> {
        return object : PresenterFactory<ArtistPresenter> {
            override fun create(): ArtistPresenter {
                return artistPresenter.get()
            }
        }
    }

    override val layout: Int
        get() = R.layout.activity_artist

    override fun injectViewComponent(viewComponent: ViewComponent) {
        viewComponent.inject(this)
    }

    override fun onResume() {
        super.onResume()
        albumList.addOnScrollListener(scrollListener)
    }

    override fun onPause() {
        super.onPause()
        albumList.removeOnScrollListener(scrollListener)
    }

    private fun initUi() {

        val bundle = intent.extras
        val artist = bundle.getParcelable<ArtistModel>(ARG_ARTIST)

        presenter?.setArtist(artist)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = artist.name

        mActionBarBackgroundDrawable = ContextCompat.getDrawable(this, R.drawable.ab_background)
        mActionBarBackgroundDrawable!!.alpha = 0

        supportActionBar?.setBackgroundDrawable(mActionBarBackgroundDrawable)

        scrollView.setOnScrollChangedListener(mOnScrollChangedListener)

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            mActionBarBackgroundDrawable!!.callback = mDrawableCallback
        }

        initializeRecyclerView()
    }

    private fun initializeRecyclerView() {
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        scrollListener = object : EndlessScrollListener(layoutManager!!) {
            override fun onLoadMore(itemsCount: Int) {
                presenter?.loadNextPage(itemsCount)
            }
        }
        albumList.layoutManager = layoutManager
        albumList.setHasFixedSize(false)
        albumsAdapter = AlbumsHorizontalAdapter( object : AlbumViewHolder.AlbumListener {
            override fun onClick(album: AlbumModel) {
                presenter?.goToAlbumList(this@ArtistActivity,album)
            }
        })
        albumList.adapter = albumsAdapter

        trackList.layoutManager = LinearLayoutManager(this)
        trackList.setHasFixedSize(false)
        tracksAdapter = TracksAdapter( object : TrackViewHolder.TrackListener {
            override fun onClick(trackModel: TrackModel) {
                audioController.startAudio(trackModel)
            }
        })
        trackList.adapter = tracksAdapter

    }

    private val mOnScrollChangedListener = object : NotifyingScrollView.OnScrollChangedListener {
        override fun onScrollChanged(who: NestedScrollView, l: Int, t: Int, oldl: Int, oldt: Int) {
            val headerHeight = artistImage.height - supportActionBar!!.height
            val ratio = Math.min(Math.max(t, 0), headerHeight).toFloat() / headerHeight
            val newAlpha = (ratio * 255).toInt()
            mActionBarBackgroundDrawable!!.alpha = newAlpha
        }
    }

    private val mDrawableCallback = object : Drawable.Callback {
        override fun invalidateDrawable(who: Drawable) {
            supportActionBar?.setBackgroundDrawable(who)
        }

        override fun scheduleDrawable(who: Drawable, what: Runnable, `when`: Long) {}

        override fun unscheduleDrawable(who: Drawable, what: Runnable) {}
    }




}
