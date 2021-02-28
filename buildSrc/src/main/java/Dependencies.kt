object App {
    val id = "com.cvillaseca.spotifykt"
}

object Modules {
    const val app = ":app"

    const val cache = ":common:base.cache"
    const val network = ":common:base.network"
    const val presentation = ":common:base.presentation"
    const val navigation = ":common:base.navigation"
    const val view = ":common:base.view"
    const val debug_tools = ":common:base.debug_tools"

    const val spotify_api = ":shared:lib.spotify_api"

    const val login = ":features:feat.login"
    const val home = ":features:feat.home"
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0"
}

object Versions {
    const val gradle        = "3.3.1"

    const val minSdk        = 26
    const val compileSdk    = 28
    const val targetSdk     = 28

    const val googleAuth = "16.0.1"

    const val googleServices = "4.2.0"

    const val firebaseAuth = "16.0.4"
    const val firebaseCore = "16.0.4"

    const val fabric = "1.27.1"

    const val appcompat = "1.2.0"
    const val materialDesign = "1.2.1"
    const val cardview = "1.0.0"
    const val recyclerview = "1.0.0"
    const val maps = "15.0.1"
    const val customtabs = "23.3.0"
    const val constraintLayout = "1.1.2"

    const val ktx = "1.2.0"

    const val kotlin                = "1.4.30"
    const val retrofit              = "2.7.1"
    const val okhttp                = "4.3.1"
    const val paperdb               = "2.6"
    const val glide                 = "4.9.0"
    const val moshi                 = "1.8.0"
    const val lifecycle             = "2.0.0"
    const val leakCanary            = "1.6.3"
    const val crashlytics           = "2.9.9"
    const val deeplinkDispatch      = "4.1.0"
    const val playCore              = "1.4.0"
    const val junit                 = "4.12"
    const val assertjCore           = "3.12.1"
    const val mockitoKotlin         = "2.1.0"
    const val timber                = "4.7.1"
    const val mavericks             = "2.0.0"
    const val compose               = "1.0.0-beta01"
    const val hilt                  = "2.33-beta"
    const val epoxy                 = "3.11.0"
    const val detekt                = "1.14.0"
    const val coroutines            = "1.4.2"
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

    const val paperdb                   = "io.paperdb:paperdb:${Versions.paperdb}"
    const val moshi                     = "com.squareup.moshi:moshi:${Versions.moshi}"

    const val ktx                       = "androidx.core:core-ktx:${Versions.ktx}"
    const val activityKtx               = "androidx.activity:activity-ktx:1.1.0"

    const val maps                      = "com.google.android.gms:play-services-maps:${Versions.maps}"

    const val timber                    = "com.jakewharton.timber:timber:${Versions.timber}"

    const val glide                     = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler             = "com.github.bumptech.glide:compiler:${Versions.glide}"

    const val shimmerLayout       =     "io.supercharge:shimmerlayout:2.1.0"

    const val lifecycleExtensions       = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val lifecycleCompiler         = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"

    const val leakCanaryAndroid         = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"
    const val leakCanaryAndroidNoOp     = "com.squareup.leakcanary:leakcanary-android-no-op:${Versions.leakCanary}"
    const val leakCanaryAndroidSupportFragment = "com.squareup.leakcanary:leakcanary-support-fragment:${Versions.leakCanary}"

    const val crashlytics               = "com.crashlytics.sdk.android:crashlytics:${Versions.crashlytics}"

    const val deeplinkDispatch          = "com.airbnb:deeplinkdispatch:${Versions.deeplinkDispatch}"

    const val flipper                   = "com.facebook.flipper:flipper:0.31.2"
    const val flipperNetwork            = "com.facebook.flipper:flipper-network-plugin:0.31.2"
    const val soLoader                  = "com.facebook.soloader:soloader:0.8.2"

    const val mavericks                 = "com.airbnb.android:mavericks:${Versions.mavericks}"
    const val mavericksTesting          = "com.airbnb.android:mavericks-testing:${Versions.mavericks}"
    const val mavericksLauncher         = "com.airbnb.android:mavericks-launcher:${Versions.mavericks}"

    const val composeMaterial           = "androidx.compose.material:material:${Versions.compose}"
    const val composeUI                 = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeTooling            = "androidx.compose.ui:ui-tooling:${Versions.compose}"

    const val hilt                      = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val epoxy                     = "com.airbnb.android:epoxy:${Versions.epoxy}"

    const val coil                      = "dev.chrisbanes.accompanist:accompanist-coil:0.6.1"
}

object AnnotationProcessors {
    const val hilt                      = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val epoxy                     = "com.airbnb.android:epoxy-processor:${Versions.epoxy}"
}

object SupportLibraries {
    const val appcompat                 = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val cardview                  = "androidx.cardview:cardview:${Versions.cardview}"
    const val recyclerview              = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    const val customtabs                = "com.android.support:customtabs:${Versions.customtabs}"
    const val constraintLayout          = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val materialDesign            = "com.google.android.material:material:${Versions.materialDesign}"

}

object TestLibraries {
    const val junit = "junit:junit:${Versions.junit}"
    const val assertjCore = "org.assertj:assertj-core:${Versions.assertjCore}"
    const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlin}"
    const val lifecycleTesting = "androidx.arch.core:core-testing:${Versions.lifecycle}"
}
