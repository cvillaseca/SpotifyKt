package com.cvillaseca.spotifykt.login.presentation

import com.airbnb.mvrx.BaseMvRxViewModel
import com.cvillaseca.spotifykt.login.domain.LoginUseCase
import com.cvillaseca.spotifykt.presentation.di.AssistedViewModelFactory
import com.cvillaseca.spotifykt.presentation.di.DaggerMvRxViewModelFactory
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject

class LoginViewModel @AssistedInject constructor(
    @Assisted state: LoginState,
    loginUseCase: LoginUseCase
) : BaseMvRxViewModel<LoginState>(state) {

//    fun login(user: String, password: String) =
//        loginUseCase(user, password)
//            .subscribeOn(Schedulers.io())
//            .execute {
//                copy(loggedIn = it)
//            }

    @AssistedInject.Factory
    interface Factory : AssistedViewModelFactory<LoginViewModel, LoginState> {
        override fun create(state: LoginState): LoginViewModel
    }

    companion object : DaggerMvRxViewModelFactory<LoginViewModel, LoginState>(LoginViewModel::class.java)
}
