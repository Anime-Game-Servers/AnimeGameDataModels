package org.anime_game_servers.game_data_models.gi.data.dungeon

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

@DataEnum
@Serializable
enum class DungeonSubType(val id: Int): IntKey {
    @NoneEntry
    DUNGEON_SUB_NONE(0),
    DUNGEON_SUB_RELIQUARY(1),
    DUNGEON_SUB_TALENT(2),
    DUNGEON_SUB_WEAPON(3),
    DUNGEON_SUB_BOSS(4),
    DUNGEON_SUB_LEY_LINE_CHALLENGE(45),

    @UnknownEntry
    DUNGEON_SUB_UNKNOWN(9999);

    override fun getIntKey() = id
}
