package com.cvillaseca.spotifykt.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.airbnb.mvrx.*


@Composable
fun <VM : MavericksViewModel<S>, S : MavericksState> VM.collectState(): S {
    val state by stateFlow.collectAsState(initial = withState(this) { it })
    return state
}

@Composable
inline fun <reified VM : MavericksViewModel<S>, reified S : MavericksState> mavericksViewModel(): VM {
    val viewModelClass = VM::class
    val viewModelContext = when (val lifecycleOwner = LocalLifecycleOwner.current) {
        is Fragment -> {
            val activity = lifecycleOwner.requireActivity()
            val args = lifecycleOwner.arguments?.get(Mavericks.KEY_ARG)
            FragmentViewModelContext(activity, args, lifecycleOwner)
        }
        is FragmentActivity -> {
            val args = lifecycleOwner.intent.extras?.get(Mavericks.KEY_ARG)
            ActivityViewModelContext(lifecycleOwner, args)
        }
        else -> error("Unknown LifecycleOwner ${lifecycleOwner::class.simpleName}. Must be Fragment or Activity for now.")
    }
    val activity = LocalContext.current as? FragmentActivity ?: error("Composable is not hosted in a FragmentActivity")
    return remember(viewModelClass, activity) {
        val keyFactory = { viewModelClass.java.name }
        MavericksViewModelProvider.get(
            viewModelClass = viewModelClass.java,
            stateClass = S::class.java,
            viewModelContext = viewModelContext,
            key = keyFactory()
        )
    }
}