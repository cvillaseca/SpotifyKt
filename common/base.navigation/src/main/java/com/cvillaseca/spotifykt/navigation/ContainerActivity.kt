package com.cvillaseca.spotifykt.navigation

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cvillaseca.spotifykt.debugtools.DebugTools
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContainerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(0, 0)
        super.onCreate(savedInstanceState)
        screenOrientation()
        loadFragment(savedInstanceState)
    }

    private fun loadFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            // configuration change (ex. rotation) or process death happened
            // avoid fragment reloading since Android restores it with existing bundle
            return
        }

        supportFragmentManager
            .beginTransaction()
            .replace(
                android.R.id.content,
                loadFragment(
                    intent.getStringExtra(FRAGMENT_NAME)!!,
                    intent.getBundleExtra(FRAGMENT_BUNDLE)
                )
            )
            .commit()
    }

    private fun screenOrientation() {
        // allow rotation on debug builds for testing
        val orientation: Int =
            when {
                DebugTools.isDebug() -> ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
                else -> ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            }
        requestedOrientation = orientation
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(0, 0)
    }

    companion object {
        const val FRAGMENT_NAME = "fragment_name"
        const val FRAGMENT_BUNDLE = "fragment_bundle"

        fun newIntent(fragmentName: String, args: Bundle): Intent =
            loadIntent(ContainerActivity::class.java.canonicalName!!)
                .putExtra(FRAGMENT_NAME, fragmentName)
                .putExtra(FRAGMENT_BUNDLE, args)
    }
}
