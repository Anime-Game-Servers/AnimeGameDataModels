package org.anime_game_servers.game_data_models.gi.data.scene.scene_tag

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey

@Serializable
enum class SceneTagCondType(val id: Int) : IntKey {
    /**
     * No condition
     */
    SCENE_TAG_COND_TYPE_NONE(0),
    SCENE_TAG_COND_TYPE_SPECIFIC_ACTIVITY_OPEN(1),
    SCENE_TAG_COND_TYPE_QUEST_GLOBAL_VAR_EQUAL(2),
    SCENE_TAG_COND_TYPE_ACTIVITY_CONTENT_OPEN(4),
    SCENE_TAG_COND_TYPE_QUEST_FINISH(5),
    SCENE_TAG_COND_TYPE_UNKNOWN(9999);

    override fun getIntKey() = id
}