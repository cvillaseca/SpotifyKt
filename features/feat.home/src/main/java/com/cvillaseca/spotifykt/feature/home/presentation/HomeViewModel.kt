package com.cvillaseca.spotifykt.feature.home.presentation

import com.airbnb.mvrx.MavericksViewModelFactory
import com.cvillaseca.spotifykt.feature.home.domain.GetHomeInfoUseCase
import com.cvillaseca.spotifykt.presentation.MvRxViewModel
import com.cvillaseca.spotifykt.presentation.di.AssistedViewModelFactory
import com.cvillaseca.spotifykt.presentation.di.hiltMavericksViewModelFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch

class HomeViewModel @AssistedInject constructor(
    @Assisted state: HomeState,
    private val useCase: GetHomeInfoUseCase
) : MvRxViewModel<HomeState>(state) {

    init {
        loadInfo()
    }

    fun loadInfo() {
        useCase.invoke().execute {
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
