
plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

dependencies{
    implementation(projects.features.auth.data)
    implementation(libs.javax.inject)
    implementation(projects.storage)
    implementation(projects.network)
}