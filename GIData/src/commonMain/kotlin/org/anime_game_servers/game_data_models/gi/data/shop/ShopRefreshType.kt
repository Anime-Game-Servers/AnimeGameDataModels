package org.anime_game_servers.game_data_models.gi.data.shop

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

@DataEnum
@Serializable
enum class ShopRefreshType(val id: Int) : IntKey {
    @NoneEntry
    SHOP_REFRESH_NONE(0),
    SHOP_REFRESH_MONTHLY(1),
    SHOP_REFRESH_WEEKLY(2),
    SHOP_REFRESH_DAILY(3),

    @UnknownEntry
    SHOP_REFRESH_UNKNOWN(9999);

    override fun getIntKey() = id
}
