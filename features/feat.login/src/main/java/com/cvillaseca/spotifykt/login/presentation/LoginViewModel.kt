package com.cvillaseca.spotifykt.login.presentation

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.FragmentViewModelContext
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.cvillaseca.spotifykt.login.domain.LoginUseCase
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import io.reactivex.schedulers.Schedulers

class LoginViewModel @AssistedInject constructor(
    @Assisted state: LoginState,
    private val loginUseCase: LoginUseCase
) : BaseMvRxViewModel<LoginState>(state) {

    fun login(user: String, password: String) =
        loginUseCase(user, password)
            .subscribeOn(Schedulers.io())
            .execute {
                copy(loggedIn = it)
            }

    @AssistedInject.Factory
    interface Factory {
        fun create(state: LoginState): LoginViewModel
    }

    companion object : MvRxViewModelFactory<LoginViewModel, LoginState> {
        override fun create(
            viewModelContext: ViewModelContext,
            state: LoginState
        ): LoginViewModel? {
            val fragment =
                (viewModelContext as FragmentViewModelContext).fragment<LoginFragment>()
            return fragment.viewModelFactory.create(state)
        }
    }
}
