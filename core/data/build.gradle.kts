plugins {
    id("utkualtas.android.library")
    id("utkualtas.android.library.jacoco")
    id("utkualtas.android.hilt")
}

android {
    namespace = "com.utkualtas.core.data"
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:database"))
    implementation(project(":core:network"))

    implementation(libs.androidx.core.ktx)

    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)
}