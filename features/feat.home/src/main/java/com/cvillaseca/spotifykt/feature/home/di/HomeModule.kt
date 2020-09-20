//package com.cvillaseca.spotifykt.feature.home.di
//
//import com.cvillaseca.spotifykt.feature.home.presentation.HomeViewModel
//import com.cvillaseca.spotifykt.presentation.di.AssistedViewModelFactory
//import com.cvillaseca.spotifykt.presentation.di.qualifiers.ViewModelKey
//import com.squareup.inject.assisted.dagger2.AssistedModule
//import dagger.Binds
//import dagger.Module
//import dagger.hilt.InstallIn
//import dagger.hilt.android.components.ApplicationComponent
//import dagger.hilt.migration.DisableInstallInCheck
//import dagger.multibindings.IntoMap
//
//@AssistedModule
//@Module(includes = [AssistedInject_HomeModule::class])
//@DisableInstallInCheck
//@InstallIn(ApplicationComponent::class)
//interface HomeModule {
//    @Binds
//    @IntoMap
//    @ViewModelKey(HomeViewModel::class)
//    fun homeViewModelFactory(factory: HomeViewModel.Factory): AssistedViewModelFactory<*, *>
//}
