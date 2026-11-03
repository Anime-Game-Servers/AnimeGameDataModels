package org.anime_game_servers.game_data_models.gi.data.dungeon

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

@DataEnum
@Serializable
enum class DungeonPlayType(val id: Int): IntKey {

    @NoneEntry
    DUNGEON_PLAY_TYPE_NONE(0),
    DUNGEON_PLAY_TYPE_FOGGY_MAZE(1),
    DUNGEON_PLAY_TYPE_TRIAL_AVATAR(2),
    DUNGEON_PLAY_TYPE_MIST_TRIAL(3),

    @UnknownEntry
    DUNGEON_PLAY_TYPE_UNKNOWN(9999);

    override fun getIntKey() = id
}
