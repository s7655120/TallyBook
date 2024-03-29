plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = App.namespace
    compileSdk = Versions.compileSdkVersion

    defaultConfig {
        applicationId = App.applicationId
        minSdk = 23
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//        val vectorDrawables by getting {
//            isUseSupportLibrary = true
//        }
    }

    buildTypes {
        val release by getting {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0"
    }
    packagingOptions {
        resources.excludes.apply{
            add("META-INF/AL2.0")
            add("META-INF/LGPL2.1")
        }
    }

    sourceSets{
        getByName("main").res.setSrcDirs(
            listOf(
                "src/main/res",
                "src/main/res/layouts/main",
                "src/main/res/layouts/tally",
                "src/main/res/layouts/chart",
                "src/main/res/layouts/center",
            )
        )
    }
}

dependencies {
    implementation(Libs.core_ktx)
    implementation(Libs.lifecycle_runtime_ktx)
//    implementation(Libs.activity_compose)
//    implementation(Libs.Compose_ui)
//    implementation(Libs.Compose_ui_tooling_preview)
    implementation(Libs.material)

    api(project(":common"))


//    testImplementation("junit:junit:4.13.2")
//    androidTestImplementation("androidx.test.ext:junit:1.1.5")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
//    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.3.3")
//    debugImplementation("androidx.compose.ui:ui-tooling:1.3.3")
//    debugImplementation("androidx.compose.ui:ui-test-manifest:1.3.3")


//    implementation("androidx.core:core-ktx:1.9.0")
//    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
//    implementation("androidx.activity:activity-compose:1.6.1")
//    implementation("androidx.compose.ui:ui:$compose_ui_version")
//    implementation("androidx.compose.ui:ui-tooling-preview:$compose_ui_version")
//    implementation("androidx.compose.material:material:1.3.1")
//    testImplementation("junit:junit:4.13.2")
//    androidTestImplementation("androidx.test.ext:junit:1.1.5")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
//    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$compose_ui_version")
//    debugImplementation("androidx.compose.ui:ui-tooling:$compose_ui_version")
//    debugImplementation("androidx.compose.ui:ui-test-manifest:$compose_ui_version")
}