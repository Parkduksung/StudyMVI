import com.example.studymvi.configureAndroidCompose

plugins {
    alias(libs.plugins.android.application)
}

android {
    configureAndroidCompose(this)
}