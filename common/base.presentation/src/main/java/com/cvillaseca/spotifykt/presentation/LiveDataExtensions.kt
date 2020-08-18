package com.cvillaseca.spotifykt.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

fun <T> MutableLiveData<Resource<T>>.setSuccess(data: T) =
    postValue(Resource(ResourceState.SUCCESS, data))

fun <T> MutableLiveData<Resource<T>>.setLoading() =
    postValue(Resource(ResourceState.LOADING, value?.data))

fun <T> MutableLiveData<Resource<T>>.setError(message: String? = null) =
    postValue(Resource(ResourceState.ERROR, value?.data, message))

// This extension function cleans up the code to observe LiveDatas in the LifecycleOwners. Instead of doing something
// like viewModel.liveData.observer(this, Observer) this function lets you do observe(viewModel.liveData, body),
// which is much more readable
fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T?) -> Unit) {
    liveData.observe(this, Observer(body))
}

// This extension function cleans up the code to observe LiveDatas in the LifecycleOwners. Instead of doing something
// like viewModel.liveData.observer(this, Observer) this function lets you do observe(viewModel.liveData, body),
// which is much more readable
fun <T : Any, L : LiveData<T>> LifecycleOwner.observeNotNull(liveData: L, body: (T) -> Unit) {
    liveData.observe(this, Observer { it?.let(body) })
}
