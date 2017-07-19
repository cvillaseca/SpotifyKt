package com.cvillaseca.spotifykt.domain.interactor.artist

import com.cvillaseca.spotifykt.data.entity.request.SearchRequest
import com.cvillaseca.spotifykt.domain.Messenger
import com.cvillaseca.spotifykt.domain.dto.ArtistDto
import com.cvillaseca.spotifykt.domain.interactor.UseCase
import com.cvillaseca.spotifykt.domain.repository.ArtistRepository
import io.reactivex.Observable
import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named


class SearchArtists @Inject
constructor(repository: ArtistRepository,
            messenger: Messenger,
            @Named("Thread") threadScheduler: Scheduler,
            @Named("PostExecution") postExecutionScheduler: Scheduler)
    : UseCase<SearchRequest, List<ArtistDto>, ArtistRepository>(repository, messenger, threadScheduler, postExecutionScheduler) {

    override fun buildObservable(requestData: SearchRequest): Observable<List<ArtistDto>> {
        return repository.searchArtists(requestData, messenger)
    }

}