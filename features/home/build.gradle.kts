plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)

    alias(libs.plugins.kotlinKapt)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.compose.compiler)
}

android {
    namespace = "com.tech.auth"
    buildFeatures{
        compose = true
    }
}

dependencies {

    implementation(projects.theme)
    implementation(projects.features.auth.domain)
    implementation(projects.common.utils)
    // Android core libraries
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    // Lifecycle libraries (for ViewModel, LiveData, etc.)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.runtime.compose)

    // Activity integration with Jetpack Compose
    implementation(libs.androidx.activity.compose)

    // Jetpack Compose BOM (Bill of Materials – keeps all Compose libs in sync)
    implementation(platform(libs.androidx.compose.bom))

    // Jetpack Compose UI + Material3
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // ConstraintLayout support in Compose
    implementation(libs.androidx.constraintlayout.compose)

    // Navigation in Compose
    implementation(libs.androidx.navigation.compose)

    // Hilt integration with Compose navigation
    implementation(libs.androidx.hilt.navigation.compose)

    // Ktor (Networking) – multiplatform HTTP client
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.android)
    implementation(libs.ktor.client.cio)
    implementation(libs.ktor.client.logging)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.ktor.client.auth)
    testImplementation(libs.ktor.client.mock) // Mocking for tests

    // Coroutines (for async programming)
    implementation(libs.kotlinx.coroutines.core)

    // DataStore (modern replacement for SharedPreferences)
    implementation(libs.androidx.datastore)

    // Protobuf (used with DataStore Proto)
    implementation(libs.protobuf.javalite)

    // Dependency injection (Hilt)
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    // Logging library
    implementation(libs.timber)

    // Javax Inject (for DI compatibility)
    implementation(libs.javax.inject)

    // Unit testing
    testImplementation(libs.junit)
    testImplementation(libs.truth) // Fluent assertions
    testImplementation(libs.ktor.client.mock) // Mocking HTTP calls

    // Android instrumented testing
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Compose testing
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
}