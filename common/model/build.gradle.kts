plugins {
    id("studymvi.android.library")
    kotlin("kapt")
}

android {
    namespace = "com.example.studymvi.common.model"
}

dependencies {
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
}