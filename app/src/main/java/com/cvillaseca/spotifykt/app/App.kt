package com.cvillaseca.spotifykt.app

import android.app.Application
import com.cvillaseca.spotifykt.data.manager.NetworkManager
import com.cvillaseca.spotifykt.presentation.di.component.AppComponent
import com.cvillaseca.spotifykt.presentation.di.component.DaggerAppComponent
import com.cvillaseca.spotifykt.presentation.di.module.AppModule
import javax.inject.Inject

class App : Application() {

    @Inject
    lateinit var networkManager: NetworkManager

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        initializeInjector()
        networkManager.start()
    }

    override fun onTerminate() {
        super.onTerminate()
        networkManager.stop()
    }

    private fun initializeInjector() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
        appComponent.inject(this)
    }

    fun getAppComponent(): AppComponent {
        return appComponent
    }
}