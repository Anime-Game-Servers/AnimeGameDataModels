package org.anime_game_servers.game_data_models.gi.data.hangouts

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

@DataEnum
@Serializable
enum class CoopPointType(val id: Int) : IntKey {
    /**
     * No action
     */
    @NoneEntry
    POINT_NONE (0),

    /**
     * TODO document specifics
     */
    POINT_START (1),

    /**
     * TODO document specifics
     */
    POINT_MIDDLE (2),

    /**
     * TODO document specifics
     */
    POINT_END (3),

    /**
     * An unknown type, check the representation string to get the missing enum values name
     */
    @UnknownEntry
    POINT_UNKNOWN (9999);

    override fun getIntKey() = id
}
