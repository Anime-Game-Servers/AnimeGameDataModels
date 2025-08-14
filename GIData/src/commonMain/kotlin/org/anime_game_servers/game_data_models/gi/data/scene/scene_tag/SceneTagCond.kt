package org.anime_game_servers.game_data_models.gi.data.scene.scene_tag

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import org.anime_game_servers.game_data_models.gi.helpers.nullableEnumValueOfOrDefault

@Serializable
data class SceneTagCond(
    @SerialName("type")
    val typeString : String? = null,
    @Transient
    val type: SceneTagCondType? = nullableEnumValueOfOrDefault(typeString,
        SceneTagCondType.SCENE_TAG_COND_TYPE_UNKNOWN
    ),
    val param1: Int = 0,
    val param2: Int = 0,
)
