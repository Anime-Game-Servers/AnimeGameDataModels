package org.anime_game_servers.game_data_models.gi.data.dungeon

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.nullable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.LogicType
import org.anime_game_servers.game_data_models.gi.data.general.LogicType.LOGIC_UNKNOWN
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.EnumWrapper
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry
import org.anime_game_servers.game_data_models.loader.enums.enumContainerSerializer

@DataEnum
@Serializable
enum class SettleUIType(val id: Int) : IntKey {
    SETTLE_UI_AlWAYS_SHOW(0),
    SETTLE_UI_ON_SUCCESS(1),
    SETTLE_UI_ON_FAIL(2),
    SETTLE_UI_NEVER_SHOW(3),

    @UnknownEntry
    SETTLE_UI_UNKNOWN(9999);

    override fun getIntKey() = id
}
