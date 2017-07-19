package com.cvillaseca.spotifykt.domain.interactor.album

import com.cvillaseca.spotifykt.domain.Messenger
import com.cvillaseca.spotifykt.domain.dto.AlbumDto
import com.cvillaseca.spotifykt.domain.interactor.UseCase
import com.cvillaseca.spotifykt.domain.repository.AlbumRepository
import io.reactivex.Observable
import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named

class GetAlbumById @Inject
constructor(repository: AlbumRepository,
            messenger: Messenger,
            @Named("Thread") threadScheduler: Scheduler,
            @Named("PostExecution") postExecutionScheduler: Scheduler) :
        UseCase<String, AlbumDto, AlbumRepository>(repository, messenger, threadScheduler, postExecutionScheduler) {

    override fun buildObservable(requestData: String): Observable<AlbumDto> {
        return repository.getAlbumById(requestData, messenger)
    }
}