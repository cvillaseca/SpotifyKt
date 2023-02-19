plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.cvillaseca.spotifykt.view"

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composecompiler.get()
    }
}

dependencies {
    implementation(libs.androidx.core)
    implementation(libs.compose.ui.ui)
    implementation(libs.compose.material.material)
}
