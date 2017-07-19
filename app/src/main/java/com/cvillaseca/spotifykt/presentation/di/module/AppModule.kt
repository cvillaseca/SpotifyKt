package com.cvillaseca.spotifykt.presentation.di.module

import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.cvillaseca.spotifykt.app.App
import com.cvillaseca.spotifykt.data.manager.NetworkManager
import com.cvillaseca.spotifykt.data.manager.impl.NetworkManagerImpl
import com.cvillaseca.spotifykt.presentation.di.scope.AppScope
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.realm.Realm
import javax.inject.Named

@Module
class AppModule constructor(app: App) {

    private val app: App

    init {
        this.app = app
    }

    @Provides
    @AppScope
    fun provideAppContext(): App {
        return app;
    }

    @Provides
    @Named("Thread")
    @AppScope
    fun providesThreadScheduler(): Scheduler {
        return Schedulers.io()
    }


    @Provides
    @Named("PostExecution")
    @AppScope
    fun providesPostExecutionScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    @Provides
    @AppScope
    fun providesNetworkManager(): NetworkManager {
        return NetworkManagerImpl(app)
    }

    @Provides
    @AppScope
    fun providesRealm(): Realm {
        val realm = Realm.getDefaultInstance()
        return realm
    }

    @Provides
    @AppScope
    fun providesSharedPreferences(): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(app)
    }


}