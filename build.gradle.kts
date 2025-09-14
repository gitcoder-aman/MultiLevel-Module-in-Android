// Top-level build file where you can add configuration options common to all sub-projects/modules.
import com.android.build.gradle.AppExtension
import com.android.build.gradle.AppPlugin
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.LibraryPlugin
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose.compiler) apply false

    // Code style & linting
    alias(libs.plugins.ktlint) apply false
    alias(libs.plugins.spotless) apply false

    // Kotlin related
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false
    alias(libs.plugins.kotlinSerialization) apply false
    alias(libs.plugins.kotlinKapt) apply false

    // Android related
    alias(libs.plugins.android.library) apply false

    // Dependency Injection
    alias(libs.plugins.hilt) apply false
}

fun BaseExtension.defaultConfig() {

    compileSdkVersion(36)

    defaultConfig {
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

    afterEvaluate {
        project.apply("${project.rootDir}/spotless.gradle")
    }
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