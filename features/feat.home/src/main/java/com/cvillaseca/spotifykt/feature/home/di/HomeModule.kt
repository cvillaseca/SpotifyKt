package com.cvillaseca.spotifykt.feature.home.di

import com.cvillaseca.spotifykt.feature.home.presentation.HomeViewModel
import com.cvillaseca.spotifykt.presentation.di.AssistedViewModelFactory
import com.cvillaseca.spotifykt.presentation.di.MavericksViewModelComponent
import com.cvillaseca.spotifykt.presentation.di.qualifiers.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.migration.DisableInstallInCheck
import dagger.multibindings.IntoMap

@Module
@DisableInstallInCheck
@InstallIn(MavericksViewModelComponent::class)
interface HomeModule {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun homeViewModelFactory(factory: HomeViewModel.Factory): AssistedViewModelFactory<*, *>
}
