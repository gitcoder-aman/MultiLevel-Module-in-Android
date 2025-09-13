pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Modularization"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")  // for theme
include(":app")
include(":theme")
include(":features:auth")
include(":network")
include(":features:auth:data")
include(":features:auth:domain")
