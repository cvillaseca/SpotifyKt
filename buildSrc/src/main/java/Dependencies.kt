object App {
    const val id = "com.cvillaseca.spotifykt"
}

object Modules {
    const val app = ":app"

    const val cache = ":common:base.cache"
    const val network = ":common:base.network"
    const val presentation = ":common:base.presentation"
    const val navigation = ":common:base.navigation"
    const val view = ":common:base.view"
    const val debug_tools = ":common:base.debug_tools"
    const val test_tools = ":common:base.test_tools"

    const val spotify_api = ":shared:lib.spotify_api"

    const val home = ":features:feat.home"
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0"
}

object Versions {

    const val minSdk        = 26
    const val compileSdk    = 31
    const val targetSdk     = 31

    const val cardview              = "1.0.0"
    const val maps                  = "15.0.1"
    const val customtabs            = "23.3.0"

    const val gradleVersions        = "0.41.0"
    const val gradle                = "7.3.1"

    const val kotlin                = "1.5.31"
    const val retrofit              = "2.9.0"
    const val okhttp                = "4.3.1"
    const val paperdb               = "2.7.2"
    const val moshi                 = "1.8.0"
    const val junit                 = "4.13.2"
    const val mockk                 = "1.12.2"
    const val mavericks             = "2.5.1"
    const val compose               = "1.0.5"
    const val hilt                  = "2.40.5"
    const val detekt                = "1.19.0"
    const val coroutines            = "1.6.0"
    const val materialDesign        = "1.5.0"
    const val coreTesting           = "2.1.0"
}

object Libraries {
    //ApplicationLibraries
    const val kotlin                    = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    const val retrofit                  = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val okhttp                    = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val converterGson             = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val loggingInterceptor        = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"

    const val coroutines                = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid         = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    const val paperdb                   = "io.github.pilgr:paperdb:${Versions.paperdb}"

    const val ktx                       = "androidx.core:core-ktx:1.7.0"
    const val activityKtx               = "androidx.activity:activity-ktx:1.4.0"

    const val maps                      = "com.google.android.gms:play-services-maps:${Versions.maps}"

    const val timber                    = "com.jakewharton.timber:timber:5.0.1"

    const val lifecycleExtensions       = "androidx.lifecycle:lifecycle-extensions:2.2.0"
    const val lifecycleCompiler         = "androidx.lifecycle:lifecycle-compiler:2.4.0"

    const val flipper                   = "com.facebook.flipper:flipper:0.129.0"
    const val flipperNetwork            = "com.facebook.flipper:flipper-network-plugin:0.129.0"
    const val soLoader                  = "com.facebook.soloader:soloader:0.10.3"

    const val mavericks                 = "com.airbnb.android:mavericks-compose:${Versions.mavericks}"
    const val mavericksTesting          = "com.airbnb.android:mavericks-testing:${Versions.mavericks}"
//    const val mavericksLauncher         = "com.airbnb.android:mavericks-launcher:${Versions.mavericks}"

    const val composeMaterial           = "androidx.compose.material:material:${Versions.compose}"
    const val composeUI                 = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeTooling            = "androidx.compose.ui:ui-tooling:${Versions.compose}"

    const val hilt                      = "com.google.dagger:hilt-android:${Versions.hilt}"

    const val coil                      = "io.coil-kt:coil-compose:1.4.0"
}

object AnnotationProcessors {
    const val hilt                      = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
}

object SupportLibraries {
    const val appcompat                 = "androidx.appcompat:appcompat:1.4.1"
    const val cardview                  = "androidx.cardview:cardview:${Versions.cardview}"
    const val customtabs                = "com.android.support:customtabs:${Versions.customtabs}"
    const val materialDesign            = "com.google.android.material:material:${Versions.materialDesign}"
}

object TestLibraries {
    const val junit = "junit:junit:${Versions.junit}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val lifecycleTesting = "androidx.arch.core:core-testing:${Versions.coreTesting}"
    const val coroutinesTests = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
}
