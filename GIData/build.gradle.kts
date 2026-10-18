import com.google.devtools.ksp.gradle.KspAATask

plugins {
    kotlin("multiplatform")
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.dokka)
    alias(libs.plugins.ksp)
}

group = "org.anime_game_servers.data_models"
version = libs.versions.anime.game.data.models.get()

kotlin {
    compilerOptions{
        freeCompilerArgs.add("-Xcontext-sensitive-resolution")
    }

    jvmToolchain(17)
    jvm {
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    js {
        nodejs()
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
    iosArm64()
    iosX64()

    val kspCommonMetadata = tasks.matching {
        it.name == "kspCommonMainKotlinMetadata"
    }
    sourceSets {
        commonMain {
            dependencies {
                api(project(":base"))
                api(libs.bundles.common.ags.base)
                api(libs.bundles.common.models.serialization)
                api(libs.bundles.common.models.ktx)
                implementation(libs.ags.core.gi)
                implementation(libs.bundles.common.crypto)
            }

            // ksp generated loader and registry files
            kotlin.srcDir(files(
                layout.buildDirectory.dir("generated/ksp/metadata/commonMain/kotlin/")
            ))

            // generated common resources used for MetaInf service files in the jvm target
            val generatedResources = files(
                layout.buildDirectory.dir("generated/ksp/metadata/commonMain/resources")
            ).builtBy(kspCommonMetadata)
            resources.srcDir(generatedResources)

            ksp{
                arg("type", "common")
                arg("module", project.name)
                arg("package_root", "org.anime_game_servers.game_data_models.gi")
            }
        }
        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
    }
}

dependencies {
    add("kspCommonMainMetadata", project(":processor"))
}

tasks{
    withType<KspAATask> {
        if (name != "kspCommonMainKotlinMetadata")
            dependsOn("kspCommonMainKotlinMetadata")
    }
    withType<org.gradle.jvm.tasks.Jar> {
        if (name.endsWith("SourcesJar", ignoreCase = true))
            dependsOn("kspCommonMainKotlinMetadata")
    }
}
