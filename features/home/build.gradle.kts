plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.cvillaseca.spotifykt.feature.home"

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composecompiler.get()
    }
}

dependencies {
    implementation(projects.common.cache)
    implementation(projects.common.network)
    implementation(projects.common.presentation)
    implementation(projects.common.testTools)
    implementation(projects.common.view)
    implementation(projects.shared.spotifyApi)

    implementation(libs.androidx.activity.compose)
//    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.coil.compose)
    implementation(libs.compose.material.material)
    implementation(libs.compose.ui.tooling)
    implementation(libs.compose.ui.ui)
    implementation(libs.hilt)
    implementation(libs.kotlin.coroutines.core)
    implementation(libs.kotlin.coroutines.android)

    kapt(libs.hilt.compiler)

    testImplementation(libs.mockk)
    testImplementation(libs.junit)
}
