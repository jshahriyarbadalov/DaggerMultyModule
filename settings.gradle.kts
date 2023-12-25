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

rootProject.name = "TheNewsApp"
include(":app")
include(":feature-news-api")
include(":feature-news-impl")
include(":core-network-api")
include(":core-network-impl")
