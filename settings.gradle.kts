pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://jitpack.io")
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Coin Ticker"
include(":app")
include(":core:ui")
include(":core:model")
include(":core:network")
include(":core:database")
include(":core:data")
include(":feature:home")
include(":core:common")
include(":feature:coin-detail")
