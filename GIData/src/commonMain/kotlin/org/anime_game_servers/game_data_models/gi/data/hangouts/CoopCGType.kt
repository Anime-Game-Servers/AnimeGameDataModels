package org.anime_game_servers.game_data_models.gi.data.hangouts

import org.anime_game_servers.core.base.interfaces.IntKey

enum class CoopCGType(val id: Int) : IntKey {
    /**
     * No action
     */
    CG_NONE (0),

    /**
     * TODO document specifics
     */
    CG_MALE (1),

    /**
     * TODO document specifics
     */
    CG_FEMALE (2),

    /**
     * An unknown type, check the representation string to get the missing enum values name
     */
    CG_TYPE_UNKNOWN (9999);

    override fun getIntKey() = id
}