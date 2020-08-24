package com.cvillaseca.spotifykt.login.di

import com.cvillaseca.spotifykt.login.presentation.LoginViewModel
import com.cvillaseca.spotifykt.presentation.di.AssistedViewModelFactory
import com.cvillaseca.spotifykt.presentation.di.qualifiers.ViewModelKey
import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.migration.DisableInstallInCheck
import dagger.multibindings.IntoMap

@AssistedModule
@Module(includes = [AssistedInject_LoginModule::class])
@DisableInstallInCheck
@InstallIn(ApplicationComponent::class)
interface LoginModule {
    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    fun loginViewModelFactory(factory: LoginViewModel.Factory): AssistedViewModelFactory<*, *>
}
