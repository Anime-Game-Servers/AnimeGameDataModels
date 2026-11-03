package org.anime_game_servers.game_data_models.gi.data.hangouts

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

@DataEnum
@Serializable
enum class CoopTaskCondType(val id: Int) : IntKey {
    /**
     * No action
     */
    @NoneEntry
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
    @UnknownEntry
    COOP_COND_UNKNOWN (9999);

    override fun getIntKey() = id
}
