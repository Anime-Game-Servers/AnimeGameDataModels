package org.anime_game_servers.game_data_models.gi.data.scene.level_tag

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.UnsetFloat
import org.anime_game_servers.game_data_models.gi.data.scene.scene_tag.SceneTagConfigData
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * These are level tags and their configs. On activation the defined scene tags are added or removed, the time is set or
 * scene groups are loaded based on this config. They are grouped and managed via [LevelTagGroupsData].
 * These are known names for files handled by this class:
 * ExcelBinOutput/LevelTagExcelConfigData.json
 * txt/LevelTagData.txt (with an appropriate parser)
 * @property id id of the level tag to be sent to the client
 * @property levelTagName a short string name of the tag
 * @property sceneId id of the scene where the tag is in
 * @property addSceneTagIdList list of scene tag ids from [SceneTagConfigData] to be added on activation
 * @property removeSceneTagIdList list of scene tag ids from [SceneTagConfigData] to be removed on activation
 * @property levelTagCanFixTime defines whether this tag can set the time of the scene to a fixed time
 * @property levelTagFixedEnviroTime the fixed time to set the scene to
 * @property loadDynamicGroupList list of scene groups to load on activation
 */
@DataFile("ExcelBinOutput/LevelTagExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/LevelTagData.txt", FileType.TSV, FolderType.EXCEL)
@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class LevelTagData(
    @JsonNames("ID")
    val id: Int,
    @JsonNames("level_tag_name")
    val levelTagName: String,
    @JsonNames("scene_id")
    val sceneId: Int,
    @JsonNames("add_scene_tag_id_list")
    val addSceneTagIdList: List<Int>? = null,
    @JsonNames("remove_scene_tag_id_list")
    val removeSceneTagIdList: List<Int>? = null,
    @JsonNames("level_tag_can_fix_time")
    val levelTagCanFixTime: Boolean = false,
    @JsonNames("level_tag_fixed_enviro_time")
    val levelTagFixedEnviroTime: Float = UnsetFloat,
    @JsonNames("load_dynamic_group_list")
    val loadDynamicGroupList: List<Int>? = null,
) : IntKey {
    override fun getIntKey() = id
}