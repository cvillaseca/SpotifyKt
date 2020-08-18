package com.cvillaseca.spotifykt.feature.home.presentation

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.view.MenuItemCompat
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.cvillaseca.spotifykt.feature.home.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_home.*

@AndroidEntryPoint
class HomeFragment : BaseMvRxFragment(R.layout.activity_home), HomeController.AdapterCallbacks,
    SearchView.OnQueryTextListener {

    private val viewModel: HomeViewModel by fragmentViewModel()

    private val controller = HomeController(this)

    private var searchView: SearchView? = null
    private val queryTextListener: SearchView.OnQueryTextListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        controller.onRestoreInstanceState(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        controller.onSaveInstanceState(outState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.setController(controller)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_menu, menu)
        val searchManager = requireActivity().getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView = MenuItemCompat.getActionView(menu.findItem(R.id.search)) as SearchView

        searchView?.setSearchableInfo(searchManager.getSearchableInfo(requireActivity().getComponentName()))
        //        searchView.setSubmitButtonEnabled(true);
        searchView?.setOnQueryTextListener(this)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun invalidate() = withState(viewModel) {
        controller.setData(it.homeInfo)
    }

    override fun onListCarClick() {
        TODO("Not yet implemented")
    }

    override fun onTopCityClick(position: Int) {
        TODO("Not yet implemented")
    }

    override fun onQueryTextSubmit(query: String?): Boolean = false

    override fun onQueryTextChange(newText: String?): Boolean =
        viewModel.onQueryTextChange(newText)
}
