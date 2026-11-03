package org.anime_game_servers.game_data_models.gi.data.item

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

@DataEnum
@Serializable
enum class ItemType(val id: Int) : IntKey {
    @NoneEntry
    ITEM_NONE(0),
    ITEM_VIRTUAL(1),
    ITEM_MATERIAL(2),
    ITEM_RELIQUARY(3),
    ITEM_WEAPON(4),
    ITEM_DISPLAY(5),
    ITEM_FURNITURE(6),
    ITEM_BEYOND_MATERIAL(7),
    ITEM_BEYOND_HALL_FACILITY(8),
    ITEM_TPS_WEAPON(9),

    @UnknownEntry
    ITEM_UNKNOWN(9999);

    override fun getIntKey() = id
}
