plugins {
    kotlin("multiplatform")
}

group = "org.anime_game_servers.data_models"
version = libs.versions.anime.game.data.models.get()

kotlin {
    compilerOptions {
        freeCompilerArgs.add("-Xcontext-sensitive-resolution")
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }
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
    //mingwX64()
    //linuxX64()
    //linuxArm64()
    //macosArm64()
    //macosX64()
    //iosArm64()
    //iosX64()


    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":base"))
                api(libs.bundles.common.ags.base)
                api(libs.bundles.common.models.serialization)
                api(libs.bundles.common.ktx)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting
        val jvmTest by getting {
            dependencies {
                implementation(project(":GIData"))
            }
        }
        val jsMain by getting
        val jsTest by getting
        //val mingwX64Main by getting
        //val linuxX64Main by getting
        //val linuxArm64Main by getting
    }
}