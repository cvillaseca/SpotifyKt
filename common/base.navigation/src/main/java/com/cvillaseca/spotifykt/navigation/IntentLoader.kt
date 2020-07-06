package com.cvillaseca.spotifykt.navigation

import android.content.Intent

private const val PACKAGE_NAME = "com.cvillaseca.spotifykt"

private fun intentTo(className: String): Intent =
    Intent(Intent.ACTION_VIEW).setClassName(PACKAGE_NAME, className)

/**
 * Method to create an Intent by reflection
 *
 * @param className Complete canonicalName name of the Activity.
 *
 * Note:
 * Method should be internal.
 * Method should only be used by Navigators from this Module.
 *
 * Public till Navigation module is complete.
 */
fun loadIntent(className: String): Intent = intentTo(className)
