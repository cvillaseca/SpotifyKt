package com.cvillaseca.spotifykt.login.di

import com.cvillaseca.spotifykt.login.data.LoginService
import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.migration.DisableInstallInCheck
import retrofit2.Retrofit

@AssistedModule
@DisableInstallInCheck
@InstallIn(FragmentComponent::class)
@Module(includes = [AssistedInject_LoginModule::class])
object LoginModule {

    @Provides
    internal fun providesLoginService(
        retrofit: Retrofit
    ): LoginService = retrofit.create(LoginService::class.java)
}
