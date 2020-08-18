package com.cvillaseca.spotifykt.search.di

import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.migration.DisableInstallInCheck

@InstallIn(FragmentComponent::class)
@AssistedModule
@DisableInstallInCheck
@Module(includes = [AssistedInject_SearchModule::class])
abstract class SearchModule
