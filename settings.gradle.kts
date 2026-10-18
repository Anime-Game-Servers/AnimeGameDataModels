plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
rootProject.name = "AnimeGameDataModels"

include("base")
include("GIData")
include("loader")
include("processor")
