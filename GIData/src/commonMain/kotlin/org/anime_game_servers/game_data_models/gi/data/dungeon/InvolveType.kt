package org.anime_game_servers.game_data_models.gi.data.dungeon

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

@DataEnum
@Serializable
enum class InvolveType(val id: Int): IntKey {
    @NoneEntry
    INVOLVE_NONE(0),
    INVOLVE_ONLY_SINGLE(1),
    INVOLVE_SINGLE_MULTIPLE(2),
    INVOLVE_DYNAMIC_MULTIPLE(3),
    INVOLVE_ONLY_MULTIPLE(4),

    @UnknownEntry
    INVOLVE_UNKNOWN(9999);

    override fun getIntKey() = id
}
