@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("studymvi.android.library")
    kotlin("kapt")
}

android {
    namespace = "com.example.studymvi.data"
}

dependencies {

    implementation(project(":core:database:datastore"))
    implementation(project(":core:database:room"))

    implementation(project(":common:model"))

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.retrofit.moshi)
}
