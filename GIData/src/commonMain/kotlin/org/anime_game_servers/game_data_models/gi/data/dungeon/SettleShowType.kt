package org.anime_game_servers.game_data_models.gi.data.dungeon

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

@DataEnum
@Serializable
enum class SettleShowType(val id: Int) : IntKey {
    @NoneEntry
    SETTLE_SHOW_NONE(0),
    SETTLE_SHOW_TIME_COST(1),
    SETTLE_SHOW_OPEN_CHEST_COUNT(2),
    SETTLE_SHOW_KILL_MONSTER_COUNT(3),
    SETTLE_SHOW_BLACKSCREEN(4),

    @UnknownEntry
    SETTLE_SHOW_UNKNOWN(9999);

    override fun getIntKey() = id
}
