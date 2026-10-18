plugins {
    kotlin("multiplatform")
}

group = "org.anime_game_servers.data_models"
version = libs.versions.anime.game.data.models.get()

kotlin {
    jvmToolchain(17)
    jvm {
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    js(IR) {
        browser {
            commonWebpackConfig {
                cssSupport {
                    enabled.set(true)
                }
            }
        }
    }
    mingwX64()
    linuxX64()
    linuxArm64()
    macosArm64()
    macosX64()
    iosArm64()
    iosX64()


    sourceSets {
        commonMain {
            dependencies {
                api(libs.bundles.common.models.serialization)
            }
        }
    }
}