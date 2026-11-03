package org.anime_game_servers.game_data_models.gi.data.activity

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

@DataEnum
@Serializable
enum class ActivityShopSheetCondType(val id: Int) : IntKey {
    /**
     * This condition requires no other condition to be met, so it's always active.
     * This is the default if nothing else is set
     */
    @NoneEntry
    ACTIVITY_SHOP_SHEET_COND_NONE(0),

    /**
     * This condition requires the user to have a quest completed before accessing a shop page. This is currently unused
     * param[0]: probably the quest id
     */
    ACTIVITY_SHOP_SHEET_COND_QUEST_FINISH(1),

    /**
     * This condition requires the day of the activity to be at least or more as the parameter.
     * param[0]: day it needs to be at least
     */
    ACTIVITY_SHOP_SHEET_COND_TIME_EQUAL_GREATER(2),

    /**
     * This condition requires the sea lamp/lantern rite event to be in a certain phase
     * param[0]: probably the phase it needs to be in
     */
    ACTIVITY_SHOP_SHEET_COND_SEA_LAMP_PHASE(3),
    /**
     * TODO
     */
    ACTIVITY_SHOP_SHEET_COND_ALCHEMY_SIM_PHASE(4),

    /**
     * This represents a condition that's not yet implemented, check the string representation for the actual value that's missing
     */
    @UnknownEntry
    ACTIVITY_SHOP_SHEET_COND_UNKNOWN(9999);

    override fun getIntKey() = id
}
