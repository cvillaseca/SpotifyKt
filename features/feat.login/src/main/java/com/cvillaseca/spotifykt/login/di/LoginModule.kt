package com.cvillaseca.spotifykt.login.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.migration.DisableInstallInCheck

@Module
@DisableInstallInCheck
@InstallIn(ApplicationComponent::class)
interface LoginModule {
//    @Binds
//    @IntoMap
//    @ViewModelKey(LoginViewModel::class)
//    fun loginViewModelFactory(factory: LoginViewModel.Factory): AssistedViewModelFactory<*, *>
}
