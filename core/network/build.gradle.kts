plugins {
    id("utkualtas.android.library")
    id("utkualtas.android.library.jacoco")
    id("utkualtas.android.hilt")
    id("kotlinx-serialization")
}

android {
    namespace = "com.utkualtas.core.network"
}

dependencies {

    implementation(project(":core:common"))
    implementation(project(":core:model"))

    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.okhttp.logging)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)
}