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
import com.cvillaseca.spotifykt.presentation.mvp.model.TrackModel
import com.cvillaseca.spotifykt.presentation.mvp.presenter.AlbumPresenter
import com.cvillaseca.spotifykt.presentation.mvp.view.AlbumView
import com.cvillaseca.spotifykt.presentation.mvp.view.AlbumViewImpl
import com.cvillaseca.spotifykt.data.audio.AudioController
import com.cvillaseca.spotifykt.presentation.ui.adapter.TracksAdapter
import com.cvillaseca.spotifykt.presentation.ui.listener.EndlessScrollListener
import com.cvillaseca.spotifykt.presentation.ui.view.scrollview.NotifyingScrollView
import com.cvillaseca.spotifykt.presentation.ui.viewholder.TrackViewHolder.TrackListener
import com.squareup.picasso.Picasso
import dagger.Lazy
import javax.inject.Inject

class AlbumActivity : BaseDaggerActivity<AlbumView, AlbumPresenter>() {

    companion object {
        val ARG_ALBUM = "ArgAlbum"
    }

    @Inject
    lateinit var artistPresenter: Lazy<AlbumPresenter>

    @Inject
    lateinit var audioController: AudioController

    @BindView(R.id.scroll_view)
    lateinit var scrollView: NotifyingScrollView

    @BindView(R.id.album_image)
    lateinit var albumImage: ImageView

    @BindView(R.id.tracks)
    lateinit var trackList: RecyclerView

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
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
        return true
    }

    override fun initView(): AlbumView {
        return object : AlbumViewImpl(this) {
            override fun renderAlbum(albumModel: AlbumModel) {
                Picasso.with(this@AlbumActivity).load(albumModel.images?.first()?.url).into(albumImage)
            }

            override fun renderTracks(tracks: List<TrackModel>) {
                tracksAdapter?.setItems(tracks)
            }

            override fun appendTracks(tracks: List<TrackModel>) {
                tracksAdapter?.addItems(tracks)
            }

        }
    }

    override val layout: Int
        get() = R.layout.activity_album

    override fun injectViewComponent(viewComponent: ViewComponent) {
        viewComponent.inject(this)
    }

    override fun onResume() {
        super.onResume()
        trackList.addOnScrollListener(scrollListener)
    }

    override fun onPause() {
        super.onPause()
        trackList.removeOnScrollListener(scrollListener)
    }

    private fun initUi() {

        val bundle = intent.extras
        val album = bundle.getParcelable<AlbumModel>(ARG_ALBUM)

        presenter?.setAlbumModel(album)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = album.name

        mActionBarBackgroundDrawable = ContextCompat.getDrawable(this, R.drawable.ab_background)
        mActionBarBackgroundDrawable!!.alpha = 0

        supportActionBar?.setBackgroundDrawable(mActionBarBackgroundDrawable)

        scrollView.setOnScrollChangedListener(mOnScrollChangedListener)

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            mActionBarBackgroundDrawable!!.callback = mDrawableCallback
        }

        initializeRecyclerView()
    }

    override fun presenterFactory(): PresenterFactory<AlbumPresenter> {
        return object : PresenterFactory<AlbumPresenter> {
            override fun create(): AlbumPresenter {
                return artistPresenter.get()
            }
        }
    }

    private fun initializeRecyclerView() {
        layoutManager = LinearLayoutManager(this)
        scrollListener = object : EndlessScrollListener(layoutManager!!) {
            override fun onLoadMore(itemsCount: Int) {
                presenter?.loadNextPage(itemsCount)
            }
        }

        trackList.layoutManager = layoutManager
        trackList.setHasFixedSize(false)
        tracksAdapter = TracksAdapter( object : TrackListener {
            override fun onClick(trackModel: TrackModel) {
                audioController.startAudio(trackModel)
            }
        })
        trackList.adapter = tracksAdapter
    }

    private val mOnScrollChangedListener = object : NotifyingScrollView.OnScrollChangedListener {
        override fun onScrollChanged(who: NestedScrollView, l: Int, t: Int, oldl: Int, oldt: Int) {
            val headerHeight = albumImage.height - supportActionBar!!.height
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
