package org.anime_game_servers.game_data_models.gi.data.dungeon

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

@DataEnum
@Serializable
enum class DungeonRosterCycleType(val id: Int) : IntKey {
    @NoneEntry
    DUNGEON_ROSTER_CYCLE_TYPE_NONE(0),
    DUNGEON_ROSTER_CYCLE_TYPE_BY_ORDER(1),

    @UnknownEntry
    DUNGEON_ROSTER_CYCLE_TYPE_UNKNOWN(9999);

    override fun getIntKey() = id
}
