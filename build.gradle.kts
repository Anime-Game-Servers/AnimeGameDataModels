import org.gradle.kotlin.dsl.libs

plugins {
    `version-catalog`
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.vanniktech.mavenPublish) apply false
}

group = "org.anime_game_servers.data_models"
version = libs.versions.anime.game.data.models

repositories {
    mavenCentral()
    google()
}

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        maven {
            name = "ags-mvn-Releases"
            url = uri("https://mvn.animegameservers.org/releases")
        }
        maven {
            name = "ags-mvn-Snapshots"
            url = uri("https://mvn.animegameservers.org/snapshots")
        }
    }

    dependencies {
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}
subprojects {
    val libs = rootProject.libs
    val mavenPublishId = libs.plugins.vanniktech.mavenPublish.get().pluginId
    apply(plugin = mavenPublishId)

    plugins.withId(mavenPublishId) {
        extensions.configure<PublishingExtension>("publishing") {
            repositories {
                maven {
                    name = "agsmvnrelease"
                    url = uri("https://mvn.animegameservers.org/releases")
                    credentials(PasswordCredentials::class)
                }
                maven {
                    name = "agsmvnsnapshots"
                    url = uri("https://mvn.animegameservers.org/snapshots")
                    credentials(PasswordCredentials::class)
                }
            }
        }
    }
}
