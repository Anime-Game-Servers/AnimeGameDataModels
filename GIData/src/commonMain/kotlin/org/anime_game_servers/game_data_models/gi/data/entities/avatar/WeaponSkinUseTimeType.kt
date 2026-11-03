package org.anime_game_servers.game_data_models.gi.data.entities.avatar

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.Version.GI_5_7_0
import org.anime_game_servers.core.base.annotations.AddedIn
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

@AddedIn(GI_5_7_0)
@DataEnum
@Serializable
enum class WeaponSkinUseTimeType(val id: Int): IntKey {
    @NoneEntry
    USE_TIME_TYPE_NONE(0),
    USE_TIME_TYPE_LEY_LINE(1),

    @UnknownEntry
    USE_TIME_TYPE_UNKNOWN(99999);

    override fun getIntKey() = id
}
