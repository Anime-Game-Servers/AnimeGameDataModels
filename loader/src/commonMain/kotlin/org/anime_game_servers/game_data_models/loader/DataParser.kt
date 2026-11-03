package org.anime_game_servers.game_data_models.loader

import org.anime_game_servers.game_data_models.loader.stripping.StripConfig

interface DataParser {
    val supportedTypes: List<FileType>
    suspend fun <T> parseModel(classInfo: DataClassInfo<T>, source:AGDMFile, stripConfig: StripConfig): T?
    suspend fun <T> parseList(classInfo: DataClassInfo<T>, source:AGDMFile, stripConfig: StripConfig): List<T>?
    suspend fun <T, K> parseMap(classInfo: DataClassInfo<T>, source:AGDMFile, stripConfig: StripConfig): Map<K, T>?
}