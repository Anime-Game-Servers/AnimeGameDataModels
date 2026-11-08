package org.anime_game_servers.game_data_models.gi.helpers

import org.anime_game_servers.game_data_models.loader.enums.EnumMetadata
import org.anime_game_servers.game_data_models.loader.enums.EnumWrapper

inline fun Int.getDefault() = if(this == -1) 0 else this
inline fun Int?.getDefault() = if(this == null || this == -1) 0 else this
inline fun Boolean?.getNonNull() = this ?: false
inline fun String?.getNonNull() = this ?: ""
inline fun <T> List<T>?.getNonNull() = this ?: emptyList()
inline fun <K,V> Map<K,V>?.getNonNull() = this ?: emptyMap()
inline fun <T: Enum<T>, M: EnumMetadata<T>> EnumWrapper<T>?.getValueNonNull(metadata: M) = this?.value ?: metadata.noneEntry ?: metadata.unknownEntry