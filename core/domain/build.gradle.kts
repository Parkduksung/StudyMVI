plugins {
    id("studymvi.android.library")
    kotlin("kapt")
}

android {
    namespace = "com.example.studymvi.core.domain"
}

dependencies {

    implementation(project(":core:data"))
    implementation(project(":core:database:datastore"))
    implementation(project(":core:database:room"))

    implementation(project(":common:model"))
    implementation(project(":common:base"))

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.kotlinx.coroutines.android)
}