package com.cvillaseca.spotifykt.feature.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.cvillaseca.spotifykt.view.ui.SpotifyKtTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), MavericksView {
    val viewModel: HomeViewModel by fragmentViewModel()

//    private var _binding: HelloHiltFragmentBinding? = null
//    private val binding get() = _binding ?: error("Binding was null!")
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        _binding = HelloHiltFragmentBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onDestroyView() {
//        _binding = null
//        super.onDestroyView()
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        ComposeView(inflater.context).apply {
            layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, MATCH_PARENT)
            setContent {
                SpotifyKtTheme {
                    HomeScreen()
                }
            }
        }

    override fun invalidate() = withState(viewModel) { state ->

    }
}