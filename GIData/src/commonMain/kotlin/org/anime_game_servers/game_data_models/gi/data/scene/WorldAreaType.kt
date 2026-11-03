package org.anime_game_servers.game_data_models.gi.data.scene

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

/**
 * TODO find out what this used for
 */
@DataEnum
@Serializable
enum class WorldAreaType(val id: Int) : IntKey {
    @NoneEntry
    LEVEL_NONE(0),
    LEVEL_1(1),
    LEVEL_2(2),
    LEVEL_3(3),
    LEVEL_PLAY(10),

    @UnknownEntry
    LEVEL_UNKNOWN(9999);

    override fun getIntKey() = id
}
