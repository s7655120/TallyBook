pluginManagement {
    repositories {
        google()
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
rootProject.name = "TallyBook"
include(":app")

include(":CommonKotlin")
include(":StartOver")
include(":Accounting")
include(":build_logic")
include(":common")
