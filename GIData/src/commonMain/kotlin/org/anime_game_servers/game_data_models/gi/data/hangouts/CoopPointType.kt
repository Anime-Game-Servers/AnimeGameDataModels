package org.anime_game_servers.game_data_models.gi.data.hangouts

import org.anime_game_servers.core.base.interfaces.IntKey

enum class CoopPointType(val id: Int) : IntKey {
    /**
     * No action
     */
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
    POINT_UNKNOWN (9999);

    override fun getIntKey() = id
}