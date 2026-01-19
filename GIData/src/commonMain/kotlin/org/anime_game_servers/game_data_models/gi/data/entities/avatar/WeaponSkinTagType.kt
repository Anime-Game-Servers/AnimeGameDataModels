package org.anime_game_servers.game_data_models.gi.data.entities.avatar

import org.anime_game_servers.core.base.Version.GI_5_7_0
import org.anime_game_servers.core.base.annotations.AddedIn
import org.anime_game_servers.core.base.interfaces.IntKey

@AddedIn(GI_5_7_0)
enum class WeaponSkinTagType(val id: Int): IntKey {
    TAG_TYPE_NONE(0),
    TAG_TYPE_COLOR_BY_ELEMENT(1),
    TAG_TYPE_UNKNOWN(99999);

    override fun getIntKey() = id
}