@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("studymvi.android.application")
    id("studymvi.android.application.compose")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.studymvi"

    defaultConfig {
        applicationId = "com.example.studymvi"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
        aidl = false
        buildConfig = false
        renderScript = false
        shaders = false
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.androidxComposeCompiler.get()
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}



dependencies {

    implementation(project(":ui:text"))
    implementation(project(":ui:designsystem"))

    implementation(project(":common:base"))
    implementation(project(":common:navigation"))


    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    androidTestImplementation(libs.hilt.android.testing)
    kaptAndroidTest(libs.hilt.android.compiler)
    testImplementation(libs.hilt.android.testing)
    kaptTest(libs.hilt.android.compiler)
    implementation(libs.androidx.hilt.navigation.compose)

    api(libs.androidx.navigation.compose)
}
