plugins {
    id("utkualtas.android.library")
    id("utkualtas.android.library.compose")
    id("utkualtas.android.library.jacoco")
}

android {
    namespace = "com.utkualtas.core.ui"

}

dependencies {

    implementation(project(":core:model"))
    implementation(libs.androidx.core.ktx)

    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.compose.material3)
    debugApi(libs.androidx.compose.ui.tooling)
    api(libs.androidx.compose.ui.tooling.preview)
    api(libs.androidx.compose.ui.util)
    api(libs.androidx.compose.runtime)
    api(libs.androidx.compose.runtime.livedata)
    api(libs.accompanist.permissions)
    api(libs.kotlinx.collections)

    implementation(libs.airbnb.lottie)
    implementation(libs.coil.kt)
    implementation(libs.coil.kt.compose)
}