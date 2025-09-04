plugins {

    // Android application plugin
    id("com.android.application") version "8.12.2"

    // Kotlin Android plugin for Android development
    id("org.jetbrains.kotlin.android") version "2.2.10"

    id("org.jetbrains.kotlin.plugin.compose") version "2.2.10"

    kotlin("kapt")


    // Kotlin Serialization plugin (used with Ktor/JSON serialization)
    id("org.jetbrains.kotlin.plugin.serialization") version "2.2.10"

    // Hilt dependency injection
    id("com.google.dagger.hilt.android") version "2.57.1"

    // Protobuf (for data serialization)
    id("com.google.protobuf") version "0.9.5"

    // Code style checker (ktlint)
    id("org.jlleitschuh.gradle.ktlint") version "13.1.0"

    // Code formatter (Spotless)
    id("com.diffplug.spotless") version "7.2.1"
}

android {
    namespace = "com.tech.modularization"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.tech.modularization"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}
dependencies {
    // Android core libraries
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.7.1")
    implementation("com.google.android.material:material:1.13.0")

    // Lifecycle libraries (for ViewModel, LiveData, etc.)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.9.3")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.9.3")

    // Activity integration with Jetpack Compose
    implementation("androidx.activity:activity-compose:1.10.1")

    // Jetpack Compose BOM (Bill of Materials – keeps all Compose libs in sync)
    implementation(platform("androidx.compose:compose-bom:2023.10.01"))

    // Jetpack Compose UI + Material3
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    // ConstraintLayout support in Compose
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")

    // Navigation in Compose
    implementation("androidx.navigation:navigation-compose:2.7.5")

    // Hilt integration with Compose navigation
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")

    // Ktor (Networking) – multiplatform HTTP client
    implementation("io.ktor:ktor-client-core:3.2.3")
    implementation("io.ktor:ktor-client-android:3.2.3")
    implementation("io.ktor:ktor-client-cio:3.2.3")
    implementation("io.ktor:ktor-client-logging:3.2.3")
    implementation("io.ktor:ktor-client-content-negotiation:3.2.3")
    implementation("io.ktor:ktor-serialization-kotlinx-json:3.2.3")
    implementation("io.ktor:ktor-client-auth:3.2.3")
    testImplementation("io.ktor:ktor-client-mock:3.2.3") // Mocking for tests

    // Coroutines (for async programming)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")

    // DataStore (modern replacement for SharedPreferences)
    implementation("androidx.datastore:datastore:1.1.7")

    // Protobuf (used with DataStore Proto)
    implementation("com.google.protobuf:protobuf-javalite:4.32.0")

    // Dependency injection (Hilt)
    implementation("com.google.dagger:hilt-android:2.57.1")
    kapt("com.google.dagger:hilt-android-compiler:2.57.1")

    // Logging library
    implementation("com.jakewharton.timber:timber:5.0.1")

    // Javax Inject (for DI compatibility)
    implementation("javax.inject:javax.inject:1")

    // Unit testing
    testImplementation("junit:junit:4.13.2")
    testImplementation("com.google.truth:truth:1.4.4") // Fluent assertions
    testImplementation("io.ktor:ktor-client-mock:3.2.3") // Mocking HTTP calls

    // Android instrumented testing
    androidTestImplementation("androidx.test.ext:junit:1.3.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.7.0")

    // Compose testing
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}
protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.19.4"
    }
    generateProtoTasks {
        all().forEach { task ->
            task.plugins.create("java") {
                option("lite")
            }
        }
    }
}