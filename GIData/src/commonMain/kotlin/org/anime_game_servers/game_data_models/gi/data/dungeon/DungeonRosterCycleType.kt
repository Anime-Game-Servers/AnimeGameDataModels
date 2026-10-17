package org.anime_game_servers.game_data_models.gi.data.dungeon

import org.anime_game_servers.core.base.interfaces.IntKey

enum class DungeonRosterCycleType(val id: Int) : IntKey {
    DUNGEON_ROSTER_CYCLE_TYPE_NONE(0),
    DUNGEON_ROSTER_CYCLE_TYPE_BY_ORDER(1),
    DUNGEON_ROSTER_CYCLE_TYPE_UNKNOWN(9999);

    override fun getIntKey() = id
}