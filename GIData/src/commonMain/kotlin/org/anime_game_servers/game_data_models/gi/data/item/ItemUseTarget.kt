package org.anime_game_servers.game_data_models.gi.data.item

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

@DataEnum
@Serializable
enum class ItemUseTarget(val id: Int) : IntKey {
    @NoneEntry
    ITEM_USE_TARGET_NONE(0),
    ITEM_USE_TARGET_CUR_AVATAR(1),
    ITEM_USE_TARGET_CUR_TEAM(2),
    ITEM_USE_TARGET_SPECIFY_AVATAR(3),
    ITEM_USE_TARGET_SPECIFY_ALIVE_AVATAR(4),
    ITEM_USE_TARGET_SPECIFY_DEAD_AVATAR(5),
    ITEM_USE_TARGET_PLAYER_AVATAR(6),

    @UnknownEntry
    ITEM_USE_TARGET_UNKNOWN(9999);

    override fun getIntKey() = id
}
