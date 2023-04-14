@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("studymvi.android.library")
    kotlin("kapt")
}

android {
    namespace = "com.example.studymvi.core.room"
}

dependencies {
    implementation(project(":common:model"))

    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    kapt(libs.androidx.room.compiler)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
}
