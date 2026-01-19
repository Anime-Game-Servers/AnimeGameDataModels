package org.anime_game_servers.game_data_models.gi.data.scene

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.annotations.AddedIn
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.dungeon.DungeonData


@Serializable
enum class SceneType(val id: Int) : IntKey {
    SCENE_NONE(0),

    /**
     * These are the main scenes the player can freely move in between while they are unlocked, like scene 3, which is the main world,
     * scene 4, which is the first Golden Arch Archipelago, or scene 6, which is enkanomiya.
     */
    SCENE_WORLD(1),

    /**
     * These are scene that are used for dungeons. They are normally referenced in the [DungeonData], where they might be referenced more than once for different difficulties.
     */
    SCENE_DUNGEON(2),

    /**
     * These are sub scenes of the main scenes, often interiors of buildings, like the knights of favonius headquarters, cats tail or angels share.
     */
    SCENE_ROOM(3),

    /**
     * These are the main areas of the home world (Teapot), which can be selected by the user for their home.
     */
    SCENE_HOME_WORLD(4),

    /**
     * These are sub scenes of the home world (Teapot), mainly the interiors of the different buildings.
     */
    SCENE_HOME_ROOM(5),

    /**
     * This is currently unused, but can be used for activity specific scenes in the future.
     */
    SCENE_ACTIVITY(6),

    /**
     * TODO
     */
    @AddedIn(GI_6_1_0)
    SCENE_BEYOND_EDIT(7),

    /**
     * TODO
     */
    @AddedIn(GI_6_1_0)
    SCENE_HALL_WORLD(8),

    /**
     * This is used when the type is unknown to the library, check the string version of the field to see what it contained
     */
    SCENE_UNKNOWN(9999);

    override fun getIntKey() = id
}