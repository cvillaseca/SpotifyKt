package com.cvillaseca.spotifykt.search.presentation

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.FragmentViewModelContext
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.cvillaseca.spotifykt.login.domain.SearchArtistUseCase
import com.cvillaseca.spotifykt.login.presentation.SearchState
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import io.reactivex.schedulers.Schedulers

class SearchViewModel @AssistedInject constructor(
    @Assisted state: SearchState,
    private val searchArtistUseCase: SearchArtistUseCase
) : BaseMvRxViewModel<SearchState>(state) {

    fun searchArtist(user: String, password: String) =
        searchArtistUseCase(user, password)
            .subscribeOn(Schedulers.io())
            .execute { copy(loggedIn = it) }

    @AssistedInject.Factory
    interface Factory {
        fun create(state: SearchState): SearchViewModel
    }

    companion object : MvRxViewModelFactory<SearchViewModel, SearchState> {
        override fun create(
            viewModelContext: ViewModelContext,
            state: SearchState
        ): SearchViewModel {
            val fragment =
                (viewModelContext as FragmentViewModelContext).fragment<SearchFragment>()
            return fragment.viewModelFactory.create(state)
        }
    }
}
