package org.anime_game_servers.game_data_models.gi.data.rewards

import kotlinx.serialization.Serializable
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt

/**
 * TODO document
 * @param id item id to be rewarded. This can reference to any [org.anime_game_servers.game_data_models.gi.data.item.ItemData]
 * @param count can be either empty, a static number, a float, or a range like x to y in this format "x;y"
 */
@Serializable
data class RewardPreviewItem(
    val id: Int = UnsetInt,
    val count: String? = null
)
