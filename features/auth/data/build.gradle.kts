plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    alias(libs.plugins.kotlinSerialization)
}

dependencies{
    implementation(projects.network)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.javax.inject)
}