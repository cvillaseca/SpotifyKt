plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.cvillaseca.spotifykt.cache"
}

dependencies {
    implementation(libs.paperdb)
}
