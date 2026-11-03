package org.anime_game_servers.game_data_models.gi.data.general

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

@DataEnum
@Serializable
enum class LogicType(val id: Int) : IntKey {
    @NoneEntry
    LOGIC_NONE(0),
    LOGIC_AND(1),
    LOGIC_OR(2),
    LOGIC_NOT(3),
    LOGIC_A_AND_ETCOR(4),
    LOGIC_A_AND_B_AND_ETCOR(5),
    LOGIC_A_OR_ETCAND(6),
    LOGIC_A_OR_B_OR_ETCAND(7),
    LOGIC_A_AND_B_OR_ETCAND(8),

    @UnknownEntry
    LOGIC_UNKNOWN(9999);

    override fun getIntKey() = id
}
