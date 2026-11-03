package org.anime_game_servers.game_data_models.loader.enums

data class EnumWrapper<T : Enum<T>>(
    val value: T,
    val key: String
)