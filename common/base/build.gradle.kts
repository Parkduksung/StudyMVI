plugins {
    id("studymvi.android.library")
    id("studymvi.android.library.compose")
}

android {
    namespace = "com.example.studymvi.common.base"
}

dependencies {
    api(libs.androidx.compose.runtime)
    api(libs.androidx.activity.compose)
    api(libs.kotlinx.coroutines.android)
    api(libs.retrofit.moshi)
}
