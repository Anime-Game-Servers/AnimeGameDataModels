package org.anime_game_servers.game_data_models.gi.data.entities.avatar

import org.anime_game_servers.core.base.Version.GI_5_7_0
import org.anime_game_servers.core.base.annotations.AddedIn
import org.anime_game_servers.core.base.interfaces.IntKey

@AddedIn(GI_5_7_0)
enum class WeaponSkinDisplayType(val id: Int): IntKey {
    DISPLAY_TYPE_SHOW(0),
    DISPLAY_TYPE_GAIN(1),
    DISPLAY_TYPE_GROUP_GAIN(1),
    USE_TIME_TYPE_UNKNOWN(99999);

    override fun getIntKey() = id
}