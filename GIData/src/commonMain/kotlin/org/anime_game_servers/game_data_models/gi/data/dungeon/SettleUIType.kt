@file:OptIn(ExperimentalSerializationApi::class)

package org.anime_game_servers.game_data_models.gi.data.dungeon

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

@DataEnum
@Serializable
enum class SettleUIType(val id: Int) : IntKey {
    @JsonNames("SETTLE_UI_AlWAYS_SHOW")
    SETTLE_UI_ALWAYS_SHOW(0),
    SETTLE_UI_ON_SUCCESS(1),
    SETTLE_UI_ON_FAIL(2),
    SETTLE_UI_NEVER_SHOW(3),

    @UnknownEntry
    SETTLE_UI_UNKNOWN(9999);

    override fun getIntKey() = id
}
