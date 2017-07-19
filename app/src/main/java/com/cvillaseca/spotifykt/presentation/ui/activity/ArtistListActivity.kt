package com.cvillaseca.spotifykt.presentation.ui.activity

import android.app.SearchManager
import android.content.Context
import android.support.v4.view.MenuItemCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.View
import butterknife.BindView
import com.cvillaseca.spotifykt.app.base.presentation.mvp.presenter.PresenterFactory
import com.cvillaseca.spotifykt.app.base.presentation.ui.activity.BaseDaggerActivity
import com.cvillaseca.spotifykt.presentation.di.component.ViewComponent
import com.cvillaseca.spotifykt.presentation.mvp.model.ArtistModel
import com.cvillaseca.spotifykt.presentation.mvp.presenter.ArtistListPresenter
import com.cvillaseca.spotifykt.presentation.mvp.view.ArtistListView
import com.cvillaseca.spotifykt.presentation.mvp.view.ArtistListViewImpl
import com.cvillaseca.spotifykt.presentation.ui.adapter.ArtistsAdapter
import com.cvillaseca.spotifykt.presentation.ui.listener.EndlessScrollListener
import com.cvillaseca.spotifykt.presentation.ui.viewholder.ArtistViewHolder
import com.cvillaseca.spotifykt.R

import dagger.Lazy
import javax.inject.Inject

class ArtistListActivity : BaseDaggerActivity<ArtistListView, ArtistListPresenter>(), SearchView.OnQueryTextListener {

    @Inject
    lateinit var artistListPresenter: Lazy<ArtistListPresenter>

    @BindView(R.id.artist_list)
    lateinit var recyclerView: RecyclerView

    private var artistsAdapter: ArtistsAdapter? = null
    private var layoutManager: LinearLayoutManager? = null
    private var scrollListener: EndlessScrollListener? = null
    private var searchView: SearchView? = null

    override fun onLoadFinished() {
        super.onLoadFinished()
        initUi()
    }

    override fun initView(): ArtistListView {
        return object : ArtistListViewImpl(this) {
            override fun renderArtists(artists: List<ArtistModel>) {
                artistsAdapter?.setItems(artists)
            }

            override fun appendArtists(artists: List<ArtistModel>) {
                artistsAdapter?.addItems(artists)
            }

            override fun resetPagination() {
                scrollListener?.resetScroll()
            }
        }
    }

    override val layout: Int
        get() = R.layout.activity_artist_list

    override fun injectViewComponent(viewComponent: ViewComponent) {
        viewComponent.inject(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView = MenuItemCompat.getActionView(menu.findItem(R.id.search)) as SearchView

        searchView?.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()))
        //        searchView.setSubmitButtonEnabled(true);
        searchView?.setOnQueryTextListener(this)

        return true
    }

    override fun onResume() {
        super.onResume()
        recyclerView.addOnScrollListener(scrollListener)
    }

    override fun onPause() {
        super.onPause()
        recyclerView.removeOnScrollListener(scrollListener)
    }

    override fun presenterFactory(): PresenterFactory<ArtistListPresenter> {
        return object : PresenterFactory<ArtistListPresenter> {
            override fun create(): ArtistListPresenter {
                return artistListPresenter.get()
            }
        }
    }

    private fun initUi() {
        initializeRecyclerView()
    }

    private fun initializeRecyclerView() {
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        scrollListener = object : EndlessScrollListener(layoutManager!!) {
            override fun onLoadMore(itemsCount: Int) {
                presenter?.loadNextPage(itemsCount)
            }
        }
        recyclerView.setHasFixedSize(false)

        artistsAdapter = ArtistsAdapter(object: ArtistViewHolder.ArtistListener {
            override fun onClick(view: View, artistModel: ArtistModel) {
                presenter?.goToArtistAnimated(this@ArtistListActivity, view, artistModel)
            }
        })

        recyclerView.adapter = artistsAdapter
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String): Boolean {
        presenter?.search(newText)
        return true
    }
}
