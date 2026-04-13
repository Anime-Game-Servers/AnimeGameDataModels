package org.anime_game_servers.game_data_models.gi.data.scene

import org.anime_game_servers.core.base.annotations.AddedIn
import org.anime_game_servers.core.base.interfaces.IntKey

enum class SceneMpType(val id: Int) : IntKey {
    SCENE_MP_NONE(0),
    SCENE_MP_SINGLE_PLAYER_SINGLE_MODE(1),
    @AddedIn(GI_6_5_0)
    SCENE_MP_DEFAULT_SINGLE_CAN_UNLOCK_MP(2),
    SCENE_MP_UNKNOWN(9999);

    override fun getIntKey() = id
}