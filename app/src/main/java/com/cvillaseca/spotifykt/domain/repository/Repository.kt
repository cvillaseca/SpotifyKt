package com.cvillaseca.spotifykt.domain.repository

import com.cvillaseca.spotifykt.domain.interactor.UseCase

interface Repository {

    fun register(useCase: UseCase<*,*,*>)

    fun unregister(useCase: UseCase<*,*,*>)
}