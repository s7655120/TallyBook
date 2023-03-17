pluginManagement {
    repositories {
//        google()
        maven {url = uri("https://maven.aliyun.com/repository/google")}
        maven {url = uri("https://maven.aliyun.com/repository/central")}
        maven {url = uri("https://maven.aliyun.com/repository/gradle-plugin")}
//        mavenCentral()
//        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
//        google()
//        mavenCentral()

        maven {url = uri("https://maven.aliyun.com/repository/google")}
        maven {url = uri("https://maven.aliyun.com/repository/central")}
    }
}
rootProject.name = "TallyBook"
include(":app")

include(":CommonKotlin")
include(":StartOver")
include(":Accounting")
include(":build_logic")
include(":common")
include(":core:network")
