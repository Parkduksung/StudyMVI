@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("studymvi.android.library")
    kotlin("kapt")
}

android {
    namespace = "com.example.studymvi.core.datastore"
}

dependencies {
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.datastore.preferences)
}
