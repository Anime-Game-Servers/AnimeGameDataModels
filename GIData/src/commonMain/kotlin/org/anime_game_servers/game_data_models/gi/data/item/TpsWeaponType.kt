package org.anime_game_servers.game_data_models.gi.data.item

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

/**
 * [Custom name]
 */
@DataEnum
@Serializable
enum class TpsWeaponType(val id: Int) : IntKey {

    @NoneEntry
    TPS_WEAPON_TYPE_NONE (0),
    TPS_WEAPON_TYPE_ASSAULT_RIFLE (1),
    TPS_WEAPON_TYPE_GRENADE (2),
    TPS_WEAPON_TYPE_HOWITZER (3),
    TPS_WEAPON_TYPE_SHOTGUN (4),
    TPS_WEAPON_TYPE_SNIPER (5),

    @UnknownEntry
    TPS_WEAPON_TYPE_UNKNOWN(9999);

    override fun getIntKey() = id
}