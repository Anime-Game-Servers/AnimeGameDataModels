package org.anime_game_servers.game_data_models.gi.data.dungeon

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

@DataEnum
@Serializable
enum class DungeonStateType(val id: Int) : IntKey {
    @NoneEntry
    DUNGEON_STATE_NONE(0),
    DUNGEON_STATE_RELEASE(1),
    DUNGEON_STATE_TEST(2),

    @UnknownEntry
    DUNGEON_STATE_UNKNOWN(9999);

    override fun getIntKey() = id
}
