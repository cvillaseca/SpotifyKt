plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.cvillaseca.spotifykt"

    defaultConfig {
        applicationId = "com.cvillaseca.spotifykt"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    lint {
        baseline = file("lint-baseline.xml")
        // Disable lintVital. Not needed since lint is run on CI
        checkReleaseBuilds = false
        // Ignore any tests
        ignoreTestSources = true
        // Make the build fail on any lint errors
        abortOnError = true
    }

    buildFeatures {
        buildConfig = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composecompiler.get()
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }

    packagingOptions {
        packagingOptions.resources.excludes += setOf(
            // Exclude AndroidX version files
            "META-INF/*.version",
            // Exclude consumer proguard files
            "META-INF/proguard/*",
            // Exclude the Firebase/Fabric/other random properties files
            "/*.properties",
            "fabric/*.properties",
            "META-INF/*.properties",
        )
    }

    buildTypes {
        release {
            isShrinkResources = true
            isMinifyEnabled = true
            proguardFiles("proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(projects.common.cache)
    implementation(projects.common.network)
    implementation(projects.common.presentation)
    implementation(projects.common.view)
    implementation(projects.features.home)
    implementation(projects.shared.spotifyApi)

    implementation(libs.timber)
    implementation(libs.okhttp)
    implementation(libs.retrofit)
    implementation(libs.mavericks)
    implementation(libs.compose.ui.ui)
    implementation(libs.flipper)
    implementation(libs.flipper.network)
    implementation(libs.soloader)
    implementation(libs.hilt)
            
    kapt(libs.hilt.compiler)

    testImplementation(libs.junit)
}
