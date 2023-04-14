@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("studymvi.android.library")
    id("studymvi.android.library.compose")
    kotlin("kapt")
}

android {
    namespace = "com.example.studymvi.ui.text"
}

dependencies {

    implementation(project(":core:domain"))

    implementation(project(":ui:designsystem"))

    
    implementation(project(":common:base"))
    implementation(project(":common:model"))
    implementation(project(":common:navigation"))


    // Hilt Dependency Injection
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    // Hilt and instrumented tests.
    androidTestImplementation(libs.hilt.android.testing)
    kaptAndroidTest(libs.hilt.android.compiler)

    // Hilt and Robolectric tests.
    testImplementation(libs.hilt.android.testing)
    kaptTest(libs.hilt.android.compiler)
    
    // Arch Components
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.hilt.navigation.compose)

    // Compose
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.activity.compose)
    // Tooling
    debugImplementation(libs.androidx.compose.ui.tooling)
    // Instrumented tests
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

}
