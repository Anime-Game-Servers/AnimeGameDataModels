package org.anime_game_servers.game_data_models.gi.data.activity.dragonspine

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey

/**
 * TODO document
 */
@Serializable
enum class DragonspineMissionExecType(val id: Int) : IntKey {
    DRAGON_SPINE_EXEC_TYPE_NONE(0),
    DRAGON_SPINE_EXEC_TYPE_BAN_DROP(1),
    DRAGON_SPINE_EXEC_TYPE_CLEAR_ITEM(2),
    DRAGON_SPINE_EXEC_TYPE_UNKNOWN(9999);

    override fun getIntKey() = id
}