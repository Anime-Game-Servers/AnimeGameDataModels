package org.anime_game_servers.game_data_models.gi.data.scene

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

@DataEnum
@Serializable
enum class NavmeshModeType(val id: Int) : IntKey {
    NAVMESH_MODE_DEFAULT(0),
    NAVMESH_MODE_POLYGON(1),
    NAVMESH_MODE_BOX(2),
    @UnknownEntry
    NAVMESH_MODE_UNKNOWN(9999);

    override fun getIntKey() = id
}
