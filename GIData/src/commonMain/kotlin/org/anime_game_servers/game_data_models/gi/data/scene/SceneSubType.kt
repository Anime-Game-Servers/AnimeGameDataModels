package org.anime_game_servers.game_data_models.gi.data.scene

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.annotations.AddedIn
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

@DataEnum
@Serializable
enum class SceneSubType(val id: Int) : IntKey {
    @NoneEntry
    SCENE_SUB_TYPE_NONE(0),
    SCENE_SUB_TYPE_PERSISTENT_DUNGEON(1),
    SCENE_SUB_TYPE_UGC_PLAY(2),
    @AddedIn(GI_6_1_0)
    SCENE_SUB_TYPE_BEYOND_LEVEL(3),
    @AddedIn(GI_6_5_0)
    SCENE_SUB_TYPE_FIRMAMENT(4),

    @UnknownEntry
    SCENE_SUB_TYPE_UNKNOWN(9999);

    override fun getIntKey() = id
}
