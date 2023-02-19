plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.cvillaseca.spotifykt.presentation"

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composecompiler.get()
    }
}

dependencies {
    implementation(libs.compose.ui.ui)
    implementation(libs.hilt)
    implementation(libs.mavericks)

    kapt(libs.hilt.compiler)
}
