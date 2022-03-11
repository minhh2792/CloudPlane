pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://papermc.io/repo/repository/maven-public/")
    }
}

rootProject.name = "CloudPlane"
include("CloudPlane-API", "CloudPlane-Server", "test-plugin")
