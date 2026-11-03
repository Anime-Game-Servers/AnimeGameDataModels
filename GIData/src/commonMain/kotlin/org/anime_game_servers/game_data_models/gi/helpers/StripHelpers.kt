package org.anime_game_servers.game_data_models.gi.helpers

import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.loader.enums.EnumMetadata
import org.anime_game_servers.game_data_models.loader.stripping.StripConfig
import org.anime_game_servers.game_data_models.loader.enums.EnumWrapper

/**
 * These are helpers for different common cases used by the strip functions
 * They all need to be used in the context of a [StripConfig] to access the config
 */

context(config: StripConfig)
inline fun String?.stripClientField() = if (config.removeClientOnly) this else null

context(config: StripConfig)
inline fun String?.stripServerField() = if (config.removeServerOnly) this else null

context(config: StripConfig)
inline fun <T> List<T>?.stripClientField() = if (config.removeClientOnly) this else null

context(config: StripConfig)
inline fun <T> List<T>?.stripServerField() = if (config.removeServerOnly) this else null


context(config: StripConfig)
inline fun <T : Enum<T>> T?.stripClientField() = if (config.removeClientOnly) this else null

context(config: StripConfig)
inline fun <T : Enum<T>> T?.stripServerField() = if (config.removeServerOnly) this else null


context(config: StripConfig)
fun <E: Enum<E>, W: EnumWrapper<E>, T> List<T>.stripListByEnumWrapperField(accessor: (T) -> W?, metadata: EnumMetadata<E>): List<T> {
    return this.filter {
        (!config.minify || metadata.noneEntry == null || accessor(it)?.value != metadata.noneEntry) &&
                (!config.removeUnknown || accessor(it)?.value != metadata.unknownEntry) &&
                (!config.removeNulls || accessor(it)?.value != null)
    }
}
context(config: StripConfig)
fun <E : Enum<E>> List<EnumWrapper<E>>.stripEnumWrapperListField(metadata: EnumMetadata<E>): List<EnumWrapper<E>> {
    return this.filter {
        (!config.minify || metadata.noneEntry == null || it.value != metadata.noneEntry) &&
                (!config.removeUnknown || it.value != metadata.unknownEntry)
    }
}

context(config: StripConfig)
fun <T> List<T>.stripListByIntField(accessor: (T) -> Int?): List<T> {
    return this.filter {
        (!config.minify || accessor(it) != UnsetInt) &&
                (!config.removeNulls || accessor(it) != null)
    }
}
