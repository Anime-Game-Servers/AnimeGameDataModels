package org.anime_game_servers.game_data_models.gi.data.watcher

import kotlinx.serialization.Serializable
import org.anime_game_servers.game_data_models.loader.enums.EnumWrapper

@Serializable
data class PredicateConfig(
    @Serializable(with = PredicateTypeContainerSerializer::class)
    val predicateType: EnumWrapper<PredicateType>? = null,
    val paramList: List<Int>? = null
)
