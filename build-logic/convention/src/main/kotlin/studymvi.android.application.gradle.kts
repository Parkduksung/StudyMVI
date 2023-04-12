import com.example.studymvi.configureKotlinAndroid

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    configureKotlinAndroid(this)

    defaultConfig {
        targetSdk = 33
    }

}