package org.anime_game_servers.game_data_models.gi.data.item

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

@DataEnum
@Serializable
enum class DisplayItemType(val id: Int) : IntKey {
    RELIQUARY_ITEM(0),
    BARTENDER_ITEM(1),
    RELIQUARY_ITEM_SMELT(2),
    DEFAULT_ITEM(100),

    @UnknownEntry
    ITEM_UNKNOWN(9999);

    override fun getIntKey() = id
}
