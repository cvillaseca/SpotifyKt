package com.cvillaseca.spotifykt.presentation.di.component

import com.cvillaseca.spotifykt.app.App
import com.cvillaseca.spotifykt.presentation.di.module.*
import com.cvillaseca.spotifykt.presentation.di.scope.AppScope
import dagger.Component

@AppScope
@Component(modules = arrayOf(
        AppModule::class,
        RepositoryModule::class,
        EntityStoreModule::class,
        CacheModule::class))
interface AppComponent {

    fun plus(viewModule: ViewModule): ViewComponent

    fun inject(app: App)
}