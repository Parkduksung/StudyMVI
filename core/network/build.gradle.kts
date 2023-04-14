
plugins {
    id("studymvi.android.library")
    kotlin("kapt")
}

android {
    namespace = "com.example.studymvi.core.network"

}

dependencies {

//    implementation(project(":model"))
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.kotlinx.coroutines.android)
    testImplementation(libs.kotlinx.coroutines.test)
    implementation(libs.retrofit.moshi)
//    implementation(libs.moshi.codegen)

    implementation("com.squareup.moshi:moshi-kotlin:1.12.0")
    implementation("com.squareup.moshi:moshi-kotlin-codegen:1.12.0")

}
