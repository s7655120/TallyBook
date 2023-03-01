import Versions.compose_ui_version

object Versions {
//    val support_lib = "27.0.2"
//    val retrofit = "2.3.0"
//    val rxjava = "2.1.9"

    val compileSdkVersion = 27
    val minSdkVersion = 19
    val targetSdkVersion = 27
    val versionCode = 1
    val versionName = "v1.0.0"
    val constraint = "1.0.2"
    val compose_ui_version = "1.3.3"
}

object App {
    val applicationId = "com.victor.tallybook"
    val namespace = "com.victor.tallybook"
}

object Libs {
//    val support_annotations = "com.android.support:support-annotations:${Versions.support_lib}"
//    val support_appcompat_v7 = "com.android.support:appcompat-v7:${Versions.support_lib}"
//    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
//    val retrofit_rxjava_adapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
//    val rxjava = "io.reactivex.rxjava2:rxjava:${Versions.rxjava}"

    val core_ktx = "androidx.core:core-ktx:1.9.0"
    val lifecycle_runtime_ktx = "androidx.lifecycle:lifecycle-runtime-ktx:2.5.1"
    val activity_compose = "androidx.activity:activity-compose:1.6.1"
    val compose_ui = "androidx.compose.ui:ui:${compose_ui_version}"
    val compose_ui_tooling_preview = "androidx.compose.ui:ui-tooling-preview:$compose_ui_version"
    val material = "androidx.compose.material:material:1.3.1"
    val junit = "junit:junit:4.13.2"



//    androidTestImplementation("androidx.test.ext:junit:1.1.5")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
//    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$compose_ui_version")

//    debugImplementation("androidx.compose.ui:ui-tooling:$compose_ui_version")
//    debugImplementation("androidx.compose.ui:ui-test-manifest:$compose_ui_version")
}