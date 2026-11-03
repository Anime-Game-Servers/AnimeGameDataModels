package org.anime_game_servers.game_data_models.gi.data.item

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

@DataEnum
@Serializable
enum class WeaponMaterialType(val id: Int) : IntKey {
    @NoneEntry
    WEAPON_MATERIAL_NONE(0),
    @UnknownEntry
    WEAPON_MATERIAL_UNKNOWN(9999);

    override fun getIntKey() = id
}