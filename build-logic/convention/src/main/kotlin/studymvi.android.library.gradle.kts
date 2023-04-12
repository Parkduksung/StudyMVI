import com.example.studymvi.configureKotlinAndroid

plugins {
    id("com.android.library")
    kotlin("android")
}

android {

    configureKotlinAndroid(this)

    defaultConfig {
        targetSdk = 33
    }
}