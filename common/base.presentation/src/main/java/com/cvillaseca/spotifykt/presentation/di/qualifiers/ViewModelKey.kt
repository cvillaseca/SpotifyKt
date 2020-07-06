package com.cvillaseca.spotifykt.presentation.di.qualifiers

import com.airbnb.mvrx.BaseMvRxViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out BaseMvRxViewModel<*>>)
