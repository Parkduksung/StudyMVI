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
include(":core:base")
include(":core:data")
include(":core:network")
include(":core:database:datastore")
include(":core:database:room")
include(":ui:designsystem")
include(":ui:text")
include(":common:base")
include(":model")
include(":common:model")
include(":common:navigation")
include(":core:domain")
