package org.anime_game_servers.game_data_models.gi.data.item

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

@DataEnum
@Serializable
enum class EquipType(val id: Int) : IntKey {
    @NoneEntry
    EQUIP_NONE(0),
    EQUIP_BRACER(1),
    EQUIP_NECKLACE(2),
    EQUIP_SHOES(3),
    EQUIP_RING(4),
    EQUIP_DRESS(5),
    EQUIP_WEAPON(6),
    EQUIP_TPS_WEAPON(7),

    @UnknownEntry
    EQUIP_UNKNOWN(9999);

    override fun getIntKey() = id
}
