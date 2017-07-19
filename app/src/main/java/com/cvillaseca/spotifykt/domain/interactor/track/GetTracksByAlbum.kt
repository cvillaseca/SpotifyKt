package com.cvillaseca.spotifykt.domain.interactor.track

import com.cvillaseca.spotifykt.data.entity.request.TrackRequest
import com.cvillaseca.spotifykt.domain.Messenger
import com.cvillaseca.spotifykt.domain.dto.TrackDto
import com.cvillaseca.spotifykt.domain.interactor.UseCase
import com.cvillaseca.spotifykt.domain.repository.TrackRepository
import io.reactivex.Observable
import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named

class GetTracksByAlbum @Inject
constructor(repository: TrackRepository,
            messenger: Messenger,
            @Named("Thread") threadScheduler: Scheduler,
            @Named("PostExecution") postExecutionScheduler: Scheduler)
    : UseCase<TrackRequest, List<TrackDto>, TrackRepository>(repository, messenger, threadScheduler, postExecutionScheduler) {

    override fun buildObservable(requestData: TrackRequest): Observable<List<TrackDto>> {
        return repository.getTracksByAlbum(requestData, messenger)
    }
}