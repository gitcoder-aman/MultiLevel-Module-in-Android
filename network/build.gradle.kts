
kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
    }
}
plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    id(libs.plugins.kotlinSerialization.get().pluginId)
}
dependencies{
    implementation(projects.storage)
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.cio)
    implementation(libs.ktor.client.logging)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.ktor.client.auth)
}