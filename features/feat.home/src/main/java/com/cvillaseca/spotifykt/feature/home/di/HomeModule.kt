package com.cvillaseca.spotifykt.feature.home.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.migration.DisableInstallInCheck

@Module
@DisableInstallInCheck
@InstallIn(ApplicationComponent::class)
interface HomeModule {
//    @Binds
//    @IntoMap
//    @ViewModelKey(HomeViewModel::class)
//    fun homeViewModelFactory(factory: HomeViewModel.Factory): AssistedViewModelFactory<*, *>
}
