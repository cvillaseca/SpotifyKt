package com.cvillaseca.spotifykt.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment

/**
 * Method to create a Fragment by reflection
 *
 * @param className Complete canonicalName name of the fragment.
 * @param args Optional bundle tht will be applied to the fragment.
 *
 * Note:
 * Method should be internal.
 * Method should only be used by Navigators from this Module.
 *
 * Public till Navigation module is complete.
 */
fun loadFragment(className: String, args: Bundle? = null): Fragment =
    loadClass<Fragment>(className).newInstance().apply { arguments = args }
