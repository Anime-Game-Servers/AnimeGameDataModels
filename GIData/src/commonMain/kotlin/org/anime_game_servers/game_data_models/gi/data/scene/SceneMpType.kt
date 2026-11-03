package org.anime_game_servers.game_data_models.gi.data.scene

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.annotations.AddedIn
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

@DataEnum
@Serializable
enum class SceneMpType(val id: Int) : IntKey {
    @NoneEntry
    SCENE_MP_NONE(0),
    SCENE_MP_SINGLE_PLAYER_SINGLE_MODE(1),
    @AddedIn(GI_6_5_0)
    SCENE_MP_DEFAULT_SINGLE_CAN_UNLOCK_MP(2),
    @UnknownEntry
    SCENE_MP_UNKNOWN(9999);

    override fun getIntKey() = id
}
