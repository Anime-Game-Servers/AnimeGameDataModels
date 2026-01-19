# AnimeGameDataModels (WIP)

This repo will contain the full definition, handling and documentation of all the binout/Excel data the anime game client and servers are using, together with some custom definitions.
It will also help with reading and writing them from and to the target formats (currently supported: JSON)

Usage
=====

## Include version in your project
Add the ags maven repository to your project. 
For release versions use the following:
```groovy
maven {
    name "agsmvnReleases"
    url "https://mvn.animegameservers.org/releases"
}
```

For snapshots use the following:
```groovy
maven {
    name = "agsmvnSnapshots"
    url = "https://mvn.animegameservers.org/snapshots"
}
```

Then include the dependency in your project:
```groovy
implementation("org.anime_game_servers.data_models:loader:$version") // For the basic loader of the resource files
implementation("org.anime_game_servers.data_models:GIData:$version") // For the model definitions for the GI anime game
```
of with a version toml file:
```toml
[versions]
anime_game_data_models = "$version"

[libraries]
# For the basic loader of the resource files
ags-datamodels_loader = { module = "org.anime_game_servers.data_models:loader", version.ref = "anime_game_data_models" }
# For the model definitions for the GI anime game
ags-datamodels_gidata = { module = "org.anime_game_servers.data_models:GIData", version.ref = "anime_game_data_models" }
```

### Using the data models
TODO

### Using the loader
TODO


Development
=====

## How to build it for the local maven repo
* All:    `gradlew publishToMavenLocal`
* JVM:    `graldew publishJvmPublicationToMavenLocal`
* JS:     `gradlew publishJsPublicationToMavenLocal`
* Native: `gradlew publishNativePublicationToMavenLocal`

## How to generate a documentation
You can generate a documentation if the models from their kdoc.
This will be output in `build/dokka/html`
```sh
gradlew dokkaHtml
```

Licensing
=====

This software library is licensed und the terms of the MIT license, with the exemptions noted below.

You can find a copy of the license in the [LICENSE file](LICENSE).

Exemptions:
* miHoYo and its subsidiaries are exempt from the MIT licensing and may instead license any source code authored for the AnimeGameServer projects under the Zero-Clause BSD license.
