// TODO: Remove once https://youtrack.jetbrains.com/issue/KTIJ-19369 is fixed
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("utkualtas.android.application")
    id("utkualtas.android.application.compose")
    id("utkualtas.android.hilt")
    alias(libs.plugins.google.services)
}

android {
    namespace = "com.utkualtas.cointicker"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.utkualtas.cointicker"

        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {

        debug {
            isMinifyEnabled = false
        }

        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {

    implementation(project(":core:ui"))
    implementation(project(":feature:home"))
    implementation(project(":feature:coin-detail"))
    implementation(project(":feature:favourite"))
    implementation(project(":feature:authentication"))

    // AndroidX
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.startup)
    implementation(libs.androidx.work.ktx)

    // Firebase
    implementation(platform(libs.firebase.bom))

    implementation(libs.splitties.pack.base)

}