package org.anime_game_servers.game_data_models.gi.data.scene.scene_tag

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * These are scene tags and their configs, that can be unlocked by scripts, its own conditions or different execs/actions
 * These are known names for files handled by this class:
 * ExcelBinOutput/SceneTagConfigData.json
 * txt/SceneTagData.txt (with an appropriate parser)
 * @property id id of the scene tag to be sent to the client
 * @property sceneTagName a short string name of the tag
 * @property sceneId id of the scene where the tag is in
 * @property isDefaultValid defines whether this is active by default or needs to be activated by other means
 * @property isSkipLoading TODO what is this
 * @property cond conditions to unlock this, might also be empty if it's managed by other means or default active
 */
@DataFile("ExcelBinOutput/SceneTagConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/SceneTagData.txt", FileType.TSV, FolderType.EXCEL)
@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class SceneTagConfigData(
    val id: Int,
    @JsonNames("scene_tag_name")
    val sceneTagName: String,
    @JsonNames("scene_id")
    val sceneId: Int,
    @JsonNames("is_default_valid")
    val isDefaultValid: Boolean = false,
    @JsonNames("is_skip_loading")
    val isSkipLoading: Boolean = false,
    val cond: List<SceneTagCond> = emptyList(),
) : IntKey {
    override fun getIntKey() = id
}