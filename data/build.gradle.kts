plugins {
    alias(libs.plugins.convention.android.library)
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "com.lmorda.data"
}

dependencies {
    implementation(project(":domain"))
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.logging)
    implementation(libs.ktor.client.cio)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)
}
