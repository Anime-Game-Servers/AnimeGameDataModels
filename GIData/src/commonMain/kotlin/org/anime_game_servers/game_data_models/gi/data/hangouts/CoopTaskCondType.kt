package org.anime_game_servers.game_data_models.gi.data.hangouts

import org.anime_game_servers.core.base.interfaces.IntKey

enum class CoopTaskCondType(val id: Int) : IntKey {
    /**
     * No action
     */
    COOP_COND_NONE (0),

    /**
     * TODO document specifics
     */
    COOP_COND_FINISH_QUEST (1),

    /**
     * TODO document specifics
     */
    COOP_COND_PLAYER_LEVEL (2),

    /**
     * TODO document specifics
     */
    COOP_COND_COOP_POINT_FINISH (3),

    /**
     * TODO document specifics
     */
    COOP_COND_AVATAR_FETTER_LEVEL (4),

    /**
     * TODO document specifics
     */
    COOP_COND_CHAPTER_END_ALL_FINISH (5),

    /**
     * TODO document specifics
     */
    COOP_COND_CHAPTER_END_FINISH_COUNT (6),

    /**
     * An unknown type, check the representation string to get the missing enum values name
     */
    COOP_COND_UNKNOWN (9999);

    override fun getIntKey() = id
}