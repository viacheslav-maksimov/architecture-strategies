rootProject.name = "ca-multi-module"

pluginManagement {
    repositories {
        mavenCentral()
        mavenLocal()
        gradlePluginPortal()
    }
    plugins {
        id("com.gradle.enterprise").version("3.7.1")
    }
}
include("application")
include("domain")
include("usecase")
include("infrastructure")
