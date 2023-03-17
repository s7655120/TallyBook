object Versions {
    val compileSdkVersion = 33
    val minSdkVersion = 19
    val targetSdkVersion = 33
    val versionCode = 1
    val versionName = "v1.0.0"
    val constraint = "1.0.2"
    val compose_ui_version = "1.3.3"

    val recycler_version = "1.3.0"

    val gson_version = "2.10.1"
    // Net request
    val retrofit_version = "2.9.0"
    val okhttp_version = "4.10.0"
}

object App {
    val applicationId = "com.victor.tallybook"
    val namespace = "com.victor.tallybook"
}

object Libs {
    val core_ktx = "androidx.core:core-ktx:1.9.0"
    val lifecycle_runtime_ktx = "androidx.lifecycle:lifecycle-runtime-ktx:2.5.1"
    val activity_compose = "androidx.activity:activity-compose:1.6.1"
    val Compose_ui = "androidx.compose.ui:ui:${Versions.compose_ui_version}"
    val Compose_ui_tooling_preview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose_ui_version}"
    val material = "androidx.compose.material:material:1.3.1"
    val junit = "junit:junit:4.13.2"

    val recycler_view = "androidx.recyclerview:recyclerview:${Versions.recycler_version}"


    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit_version}"
    val retrofit_converter_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit_version}"

    val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp_version}"
    val okhttp_log_interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp_version}"

    val gson = "com.google.code.gson:gson:${Versions.gson_version}"

//    androidTestImplementation("androidx.test.ext:junit:1.1.5")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
//    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$compose_ui_version")

//    debugImplementation("androidx.compose.ui:ui-tooling:$compose_ui_version")
//    debugImplementation("androidx.compose.ui:ui-test-manifest:$compose_ui_version")
}