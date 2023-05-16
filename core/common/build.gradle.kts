plugins {
    id("utkualtas.android.library")
    id("utkualtas.android.library.jacoco")
    id("utkualtas.android.hilt")
}
android {
    namespace = "com.utkualtas.core.common"
}

dependencies {

    // KotlinX
    implementation(libs.kotlinx.coroutines.android)
}