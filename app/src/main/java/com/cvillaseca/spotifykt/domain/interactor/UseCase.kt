package com.cvillaseca.spotifykt.domain.interactor

import com.cvillaseca.spotifykt.domain.Messenger
import com.cvillaseca.spotifykt.domain.repository.Repository
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import javax.inject.Named

abstract class UseCase<REQUEST_DATA, RESPONSE_DATA, REPOSITORY : Repository>(protected val repository: REPOSITORY,
                                                                             protected val messenger: Messenger,
                                                                             @param:Named("Thread") private val threadScheduler: Scheduler,
                                                                             @param:Named("PostExecution") private val postExecutionScheduler: Scheduler) {

    private val subscription = CompositeDisposable()

    protected abstract fun buildObservable(requestData: REQUEST_DATA): Observable<RESPONSE_DATA>

    fun execute(requestData: REQUEST_DATA, useCaseSubscriber: DisposableObserver<RESPONSE_DATA>) {
        this.subscription.add(this.buildObservable(requestData)
                .subscribeOn(threadScheduler)
                .observeOn(postExecutionScheduler)
                .subscribeWith(useCaseSubscriber))
        repository.register(this)
    }

    val isUnsubscribed: Boolean
        get() = !subscription.isDisposed

    fun unsubscribe() {
        if (!isUnsubscribed) {
            subscription.clear()
        }
        repository.unregister(this)
    }
}