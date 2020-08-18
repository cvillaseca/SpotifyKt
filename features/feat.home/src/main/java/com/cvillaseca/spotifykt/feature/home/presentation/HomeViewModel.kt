package com.cvillaseca.spotifykt.feature.home.presentation

import com.airbnb.mvrx.BaseMvRxViewModel
import com.cvillaseca.spotifykt.feature.home.domain.GetHomeInfoUseCase
import com.cvillaseca.spotifykt.presentation.di.AssistedViewModelFactory
import com.cvillaseca.spotifykt.presentation.di.DaggerMvRxViewModelFactory
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject

class HomeViewModel @AssistedInject constructor(
    @Assisted state: HomeState,
    private val homeReducer: HomeReducer,
    private val useCase: GetHomeInfoUseCase
) : BaseMvRxViewModel<HomeState>(state) {

    init {
        useCase.invoke()
            .map { homeReducer.toState(it) }
            .execute { copy(homeInfo = it) }
    }

    fun onQueryTextChange(newText: String?): Boolean {
        return true
    }

    @AssistedInject.Factory
    interface Factory : AssistedViewModelFactory<HomeViewModel, HomeState> {
        override fun create(state: HomeState): HomeViewModel
    }

    companion object : DaggerMvRxViewModelFactory<HomeViewModel, HomeState>(HomeViewModel::class.java)
}
