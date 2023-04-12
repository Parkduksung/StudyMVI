import com.example.studymvi.configureAndroidCompose

plugins {
    alias(libs.plugins.android.library)
}

android {
    configureAndroidCompose(this)
}