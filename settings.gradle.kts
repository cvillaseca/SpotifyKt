pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

plugins {
    id("com.gradle.enterprise") version "3.12.3"
}

gradleEnterprise {
    buildScan {
        termsOfServiceUrl = "https://gradle.com/terms-of-service"
        termsOfServiceAgree = "yes"
        publishAlways()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(
    ":app",
    ":common:cache",
    ":common:network",
    ":common:presentation",
    ":common:view",
    ":shared:spotify_api",
    ":features:home"
)
