@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("studymvi.android.library")
    id("studymvi.android.library.compose")
}

android {
    namespace = "com.example.studymvi.ui.designsystem"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material)
    debugImplementation(libs.androidx.compose.ui.tooling)
}
