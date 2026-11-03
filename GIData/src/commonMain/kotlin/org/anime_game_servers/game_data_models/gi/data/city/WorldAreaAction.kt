package org.anime_game_servers.game_data_models.gi.data.city

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

@DataEnum
@Serializable
enum class WorldAreaAction(val id: Int) : IntKey {
    @NoneEntry
    WORLD_AREA_ACTION_NONE(0),

    /**
     * TODO currently unused
     */
    WORLD_AREA_ACTION_REWARD(1),


    /**
     * This action increases the stamina of the player by the specified amount
     * param1 [0]: the amount of stamina to increase
     */
    WORLD_AREA_ACTION_IMPROVE_STAMINA(2),

    /**
     * This action unlocks a force in the world area
     * param1 [0]: the force id to unlock
     */
    WORLD_AREA_ACTION_UNLOCK_FORCE(3),

    /**
     * TODO currently unused
     */
    WORLD_AREA_ACTION_UNLOCK_DUNGEON_ENTRANCE(4),

    /**
     * TODO
     * param1 [0]: TODO
     * param2 [0]: TODO
     */
    WORLD_AREA_ACTION_ACTIVATE_ITEM(5),

    /**
     * TODO currently unused
     */
    WORLD_AREA_ACTION_UNLOCK_DYNAMIC_HARD(6),

    /**
     * TODO currently unused
     */
    WORLD_AREA_ACTION_UNLOCK_AIR_PORTAL(7),

    /**
     * TODO currently unused
     */
    WORLD_AREA_ACTION_NOTIFY_GROUP(8),

    /**
     * Used to identify unknown actions, check the string params for more information about the unknown action type
     */
    @UnknownEntry
    WORLD_AREA_ACTION_UNKNOWN(9999);

    override fun getIntKey() = id
}
