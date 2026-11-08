package org.anime_game_servers.game_data_models.gi.custom.activity

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

/**
 * This is the Condition required for changing the state of an activity (e.g. to started or active)
 * @property id The int representation of this enum
 */
@DataEnum
@Serializable
enum class ActivityStateCondType(val id: Int) : IntKey {
    @NoneEntry
    NONE(0),

    /**
     * Players requires a specific adventure rank
     * param [0]: level the player needs to reach
     */
    PLAYER_LEVEL(1),

    /**
     * Players requires specific quests to be finished
     * param: list of quest ids required, separated by commas
     */
    FINISH_QUESTS(2),

    /**
     * Players requires specific main/parent quests to be finished
     * param: list of parent quest ids required, separated by commas
     */
    FINISH_MAIN_QUESTS(3),

    @UnknownEntry
    UNKNOWN(9999);

    override fun getIntKey() = id
}
