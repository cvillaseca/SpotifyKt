package com.cvillaseca.spotifykt.login.data

import io.reactivex.Completable
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val localDataSource: LoginLocalDataSource,
    private val remoteDataSource: LoginRemoteDataSource
) {
    fun login(user: String, password: String): Completable =
        remoteDataSource.login(user, password)
            .flatMapCompletable {
                localDataSource.storeToken(it)
                Completable.complete()
            }
}
