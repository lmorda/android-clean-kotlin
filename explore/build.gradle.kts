plugins {
    alias(libs.plugins.convention.android.library)
    alias(libs.plugins.convention.compose)
    alias(libs.plugins.convention.core.lifecycle)
}

android {
    namespace = "com.lmorda.explore"
}

dependencies {
    implementation(project(":design"))
    implementation(project(":domain"))
    implementation(project(":utils"))
    implementation(libs.coil.compose)
    implementation(libs.coil.network.okhttp)
    implementation(libs.lottie)
    implementation(libs.koin.android)
    androidTestImplementation(libs.androidx.ui.test.junit4)
}
