import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension

plugins {
    kotlin("jvm") version "2.0.20" apply false
}

subprojects {
    group = "me.vihara.plugin.justahologram"
    version = "0.0.1-BETA"

    repositories {
        mavenCentral()
    }

    apply(plugin = "org.jetbrains.kotlin.jvm")

    dependencies {

    }

    extensions.configure<KotlinJvmProjectExtension> {
        jvmToolchain(17)
    }
}
