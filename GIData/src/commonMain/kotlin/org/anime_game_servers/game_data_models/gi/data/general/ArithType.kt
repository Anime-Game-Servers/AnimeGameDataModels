package org.anime_game_servers.game_data_models.gi.data.general

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

/**
 * TODO documentation
 */
@DataEnum
@Serializable
enum class ArithType(val id: Int): IntKey {
    @NoneEntry
    ARITH_NONE(0),
    ARITH_ADD(1),
    ARITH_MULTI(2),
    ARITH_SUB(3),
    ARITH_DIVIDE(3),

    @UnknownEntry
    ARITH_UNKNOWN(9999);

    override fun getIntKey() = id
}
