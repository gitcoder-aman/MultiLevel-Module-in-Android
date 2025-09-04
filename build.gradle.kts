// Top-level build file where you can add configuration options common to all sub-projects/modules.
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.AppExtension
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.android.build.gradle.AppPlugin
import com.android.build.gradle.LibraryPlugin
import com.diffplug.gradle.spotless.JavaExtension

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false

    // Code style & linting
    id("org.jlleitschuh.gradle.ktlint") version "13.1.0" apply false
    id("com.diffplug.spotless") version "7.2.1" apply false

    // Kotlin related
    id("org.jetbrains.kotlin.jvm") version "2.2.10" apply false
    id("org.jetbrains.kotlin.plugin.serialization") version "2.2.10" apply false
    id("org.jetbrains.kotlin.kapt") version "2.2.10" apply false

    // Android related
    id("com.android.library") version "8.12.2" apply false

    // Dependency Injection
    id("com.google.dagger.hilt.android") version "2.57.1" apply false
}

fun BaseExtension.defaultConfig() {

    compileSdkVersion(36)

    defaultConfig {
        applicationId = "com.tech.modularization"
        minSdk = 24
        targetSdk = 36

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    packagingOptions {
        resources.excludes.add("META-INF/AL2.0")
    }
}

fun PluginContainer.applyDefaultConfig(project: Project) {
    whenPluginAdded {
        when (this) {
            is AppPlugin -> {
                project.extensions.getByType<AppExtension>().defaultConfig()
            }
            is LibraryPlugin -> {
                project.extensions.getByType<LibraryExtension>().defaultConfig()
            }
            is JavaPlugin -> {
                project.extensions.getByType<JavaPluginExtension>().apply {
                    sourceCompatibility = JavaVersion.VERSION_11
                    targetCompatibility = JavaVersion.VERSION_11
                }
            }
        }
    }
}
subprojects{
    project.plugins.applyDefaultConfig(project)

    tasks.withType<KotlinCompile> {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
            freeCompilerArgs.addAll(
                listOf(
                    "-opt-in=androidx.compose.material3.ExperimentalMaterial3Api"
                )
            )
        }
    }

}