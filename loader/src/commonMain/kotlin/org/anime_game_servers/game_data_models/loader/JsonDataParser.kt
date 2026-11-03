package org.anime_game_servers.game_data_models.loader

import kotlinx.io.readString
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import org.anime_game_servers.game_data_models.loader.stripping.StripConfig
import org.anime_game_servers.game_data_models.loader.stripping.stripElement


class JsonDataParser(val serializer: Json): DataParser {
    override val supportedTypes: List<FileType> = listOf(FileType.JSON)

    override suspend fun <T> parseList(classInfo: DataClassInfo<T>, source: AGDMFile, stripConfig: StripConfig): List<T>? {
        return loadFileObject(ListSerializer(classInfo.serializer), source)?.let { list ->
            if (!stripConfig.shouldStrip()){
                return@let list
            }

            list.map {
                it.stripElement(stripConfig)
            }
        }
    }

    override suspend fun <T, K> parseMap(classInfo: DataClassInfo<T>, source: AGDMFile, stripConfig: StripConfig): Map<K, T>? {
        TODO("Not yet implemented")
    }

    override suspend fun <T> parseModel(classInfo: DataClassInfo<T>, source: AGDMFile, stripConfig: StripConfig): T? {
        return loadFileObject(classInfo.serializer, source).let { model ->
            if (!stripConfig.shouldStrip()){
                return@let model
            }
            model.stripElement(stripConfig)
        }
    }

    suspend fun <T> loadFileObject(deserializer: KSerializer<T>, source: AGDMFile): T {
        val string = source.getSource().readString()
        return serializer.decodeFromString(deserializer, string)
    }
}