package org.anime_game_servers.game_data_models.gi.data.item

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

@DataEnum
@Serializable
enum class MaterialDestroyType(val id: Int) : IntKey {
    @NoneEntry
    DESTROY_NONE(0),
    DESTROY_RETURN_MATERIAL(1),

    @UnknownEntry
    DESTROY_UNKNOWN(9999);

    override fun getIntKey() = id
}
