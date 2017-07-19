package com.cvillaseca.spotifykt.app.base.data.repository

import com.cvillaseca.spotifykt.app.base.data.mapper.BaseMapper
import com.cvillaseca.spotifykt.app.base.data.store.EntityStore
import com.cvillaseca.spotifykt.app.base.data.store.cache.Cache
import com.cvillaseca.spotifykt.data.manager.NetworkManager
import com.cvillaseca.spotifykt.domain.interactor.UseCase
import com.cvillaseca.spotifykt.domain.repository.Repository
import java.util.HashMap

open class RepositoryImpl<ENTITY_STORE : EntityStore, CACHE : Cache, ENTITY_DTO_MAPPER : BaseMapper<*,*>>(protected var networkManager: NetworkManager,
                                                                                                          protected var cloudStore: ENTITY_STORE,
                                                                                                          protected var cache: CACHE,
                                                                                                          protected var entityDtoMapper: ENTITY_DTO_MAPPER) : Repository {

    protected val useCasesMap: MutableMap<String, UseCase<*,*,*>> = HashMap()

    override fun register(useCase: UseCase<*,*,*>) {
        useCasesMap.put(useCase.toString(), useCase)
    }

    override fun unregister(useCase: UseCase<*,*,*>) {
        useCasesMap.remove(useCase.toString())
    }


}