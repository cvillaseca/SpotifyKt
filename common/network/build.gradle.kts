plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.cvillaseca.spotifykt.network"

    buildFeatures { buildConfig = true }
    defaultConfig {
        buildConfigField("String", "SPOTIFY_CLIENT", project.properties["spotifyClient"] as String)
        buildConfigField("String", "SPOTIFY_SECRET", project.properties["spotifySecret"] as String)
    }
}

dependencies {
    implementation(projects.common.cache)

    implementation(libs.kotlin.coroutines.core)
    implementation(libs.retrofit.gsonConverter)
    implementation(libs.flipper.network)
    implementation(libs.flipper)
    implementation(libs.hilt)
    implementation(libs.okhttp.loggingInterceptor)
    implementation(libs.okhttp)
    implementation(libs.retrofit)
    implementation(libs.timber)

    kapt(libs.hilt.compiler)
}
