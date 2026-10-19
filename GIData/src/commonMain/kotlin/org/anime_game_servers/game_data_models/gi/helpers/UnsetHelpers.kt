package org.anime_game_servers.game_data_models.gi.helpers

inline fun Int.getDefault() = if(this == -1) 0 else this
inline fun Boolean?.getNonNull() = this ?: false
inline fun String?.getNonNull() = this ?: ""
inline fun <T> List<T>?.getNonNull() = this ?: emptyList()
inline fun <K,V> Map<K,V>?.getNonNull() = this ?: emptyMap()