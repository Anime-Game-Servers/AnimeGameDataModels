package org.anime_game_servers.game_data_models.gi.data.activity.dragonspine

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

/**
 * TODO document
 */
@DataEnum
@Serializable
enum class DragonspineMissionExecType(val id: Int) : IntKey {
    @NoneEntry
    DRAGON_SPINE_EXEC_TYPE_NONE(0),
    DRAGON_SPINE_EXEC_TYPE_BAN_DROP(1),
    DRAGON_SPINE_EXEC_TYPE_CLEAR_ITEM(2),

    @UnknownEntry
    DRAGON_SPINE_EXEC_TYPE_UNKNOWN(9999);

    override fun getIntKey() = id
}
