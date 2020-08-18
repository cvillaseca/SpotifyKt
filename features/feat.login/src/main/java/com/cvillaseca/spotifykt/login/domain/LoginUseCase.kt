package com.cvillaseca.spotifykt.login.domain

import com.cvillaseca.spotifykt.login.data.LoginRepository
import io.reactivex.Completable
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) : (String, String) -> Completable {

    override fun invoke(user: String, password: String): Completable =
        loginRepository.login(user, password)
}
