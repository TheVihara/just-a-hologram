import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension

val user = findProperty("repo.skykingdoms.user")?.toString() ?: error("Missing repository user")
val pass = findProperty("repo.skykingdoms.pass")?.toString() ?: error("Missing repository password")

plugins {
    kotlin("jvm") version "2.0.20" apply false
}

subprojects {
    group = "me.vihara.plugin.justahologram"
    version = "0.0.1-BETA"

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
