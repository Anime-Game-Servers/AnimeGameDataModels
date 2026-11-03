package org.anime_game_servers.game_data_models.gi.data.scene.scene_tag

import kotlinx.serialization.Serializable
import org.anime_game_servers.game_data_models.loader.enums.EnumWrapper

@Serializable
data class SceneTagCond(
    @Serializable(with = SceneTagCondTypeContainerSerializer::class)
    val type: EnumWrapper<SceneTagCondType>? = null,
    val param1: Int = 0,
    val param2: Int = 0,
)
