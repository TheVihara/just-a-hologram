import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension

val user = findProperty("repo.skykingdoms.user")?.toString() ?: error("Missing repository user")
val pass = findProperty("repo.skykingdoms.pass")?.toString() ?: error("Missing repository password")
val buildDirectory = file("./build/")

plugins {
    id("com.gradleup.shadow") version "9.0.0-beta4" apply false
    kotlin("jvm") version "2.0.20" apply false
}

subprojects {
    group = "me.vihara.plugin.justahologram"
    version = "0.0.1-BETA"

    val customBuildDir: DirectoryProperty = project.layout.buildDirectory
    customBuildDir.set(file("$buildDirectory/${project.name}"))

    apply(plugin = "com.gradleup.shadow")

    repositories {
        mavenCentral()

        listOf(
            "https://repo.skykingdoms.net/repository/maven-snapshots/",
            "https://repo.skykingdoms.net/repository/maven-releases/"
        ).forEach { repoUrl ->
            maven {
                url = uri(repoUrl)
                credentials {
                    username = user
                    password = pass
                }
            }
        }
    }

    apply(plugin = "org.jetbrains.kotlin.jvm")

    dependencies {

    }

    extensions.configure<KotlinJvmProjectExtension> {
        jvmToolchain(17)
    }
}
