package com.cvillaseca.spotifykt.feature.home.presentation

import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.cvillaseca.spotifykt.feature.home.domain.GetHomeInfoUseCase
import com.cvillaseca.spotifykt.presentation.di.AssistedViewModelFactory
import com.cvillaseca.spotifykt.presentation.di.hiltMavericksViewModelFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class HomeViewModel @AssistedInject constructor(
    @Assisted state: HomeState,
    private val useCase: GetHomeInfoUseCase
) : MavericksViewModel<HomeState>(state) {

    init {
        loadInfo()
    }

    fun loadInfo() {
        suspend {
            useCase.run()
        }.execute {
            copy(homeInfo = it)
        }
    }

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<HomeViewModel, HomeState> {
        override fun create(state: HomeState): HomeViewModel
    }

    companion object :
        MavericksViewModelFactory<HomeViewModel, HomeState> by hiltMavericksViewModelFactory()
}
