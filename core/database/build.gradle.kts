plugins {
    id("utkualtas.android.library")
    id("utkualtas.android.library.jacoco")
    id("utkualtas.android.hilt")
}

android {
    namespace = "com.utkualtas.core.database"
}

dependencies {

    implementation(project(":core:common"))
    implementation(project(":core:model"))

    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    kapt(libs.room.compiler)
}