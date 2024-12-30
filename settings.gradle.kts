plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "just-a-hologram"
include("plugin")
include("api")
include("nms")
include("nms:common")
findProject(":nms:common")?.name = "common"
