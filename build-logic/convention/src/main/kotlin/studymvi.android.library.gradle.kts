import com.example.studymvi.configureKotlinAndroid

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {

    configureKotlinAndroid(this)

    defaultConfig {
        targetSdk = 33
    }
}