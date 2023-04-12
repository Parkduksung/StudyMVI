pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "StudyMVI"
include(":app")
include(":core:common")
include(":feature-text")
include(":core-data")
include(":core-database")
include(":core-ui")
include(":core-datastore")
include(":core-domain")
include(":core-network")
include(":core-model")
