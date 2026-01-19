package org.anime_game_servers.game_data_models.gi.data.entities.avatar

import org.anime_game_servers.core.base.Version.GI_5_7_0
import org.anime_game_servers.core.base.annotations.AddedIn
import org.anime_game_servers.core.base.interfaces.IntKey

@AddedIn(GI_5_7_0)
enum class WeaponSkinUseTimeType(val id: Int): IntKey {
    USE_TIME_TYPE_NONE(0),
    USE_TIME_TYPE_LEY_LINE(1),
    USE_TIME_TYPE_UNKNOWN(99999);

    override fun getIntKey() = id
}