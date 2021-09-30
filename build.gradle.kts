plugins {
    idea
    java

    id("com.github.johnrengelman.shadow") version "7.0.0" apply false
    id("io.papermc.paperweight.patcher") version "1.1.11"
}

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/") {
        content {
            onlyForConfigurations("paperclip")
        }
    }
}

dependencies {
    remapper("org.quiltmc:tiny-remapper:0.4.3:fat")
    paperclip("io.papermc:paperclip:2.0.1")
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "maven-publish")

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(16))
        }
    }

    tasks.withType<JavaCompile>().configureEach {
        options.encoding = "UTF-8"
        options.release.set(16)
    }

    repositories {
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
        maven("https://hub.spigotmc.org/nexus/content/groups/public/")
        maven("https://repo.md-5.net/content/repositories/releases/")
        maven("https://papermc.io/repo/repository/maven-public/")
        maven("https://oss.sonatype.org/content/groups/public/")
        maven("https://ci.emc.gs/nexus/content/groups/aikar/")
        maven("https://repo.aikar.co/content/groups/aikar")
        maven("https://repo1.maven.org/maven2/")
        maven("https://jitpack.io")
    }
}

paperweight {
    serverProject.set(project(":CloudPlane-Server"))

    useStandardUpstream("airplane") {
        url.set(github("TECHNOVE", "Airplane"))
        ref.set(providers.gradleProperty("airplaneRef"))

        withStandardPatcher {
            baseName("Airplane")

            remapRepo.set("https://maven.quiltmc.org/repository/release/")
            decompileRepo.set("https://files.minecraftforge.net/maven/")

            apiOutputDir.set(layout.projectDirectory.dir("CloudPlane-API"))
            serverOutputDir.set(layout.projectDirectory.dir("CloudPlane-Server"))
        }
    }
}
