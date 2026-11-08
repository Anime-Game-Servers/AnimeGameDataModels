package org.anime_game_servers.game_data_models.gi.data.scene

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType
import org.anime_game_servers.game_data_models.loader.enums.EnumWrapper

/**
 * This file contains information about scenes, that the server should use to manage and set up scenes the player joins.
 *
 */
@DataFile("ExcelBinOutput/SceneExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/SceneData.txt", FileType.TSV, FolderType.EXCEL)
@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class SceneData(
    val id: Int,
    @Serializable(with = SceneTypeContainerSerializer::class)
    val type: EnumWrapper<SceneType>? = null,
    @JsonNames("subtype")
    @Serializable(with = SceneSubTypeContainerSerializer::class)
    val subType: EnumWrapper<SceneSubType>? = null,
    val ignoreNavMesh: Boolean? = null,
    val useToTheMoon: Boolean? = null,
    @Serializable(with = NavmeshModeTypeContainerSerializer::class)
    val navmeshMode: EnumWrapper<NavmeshModeType>? = null,
    val levelEntityConfig: String? = null,
    val entityAppearSorted: Int? = null,
    val specifiedAvatarList: List<Int>? = null,
    val maxSpecifiedAvatarNum: Int? = null,
    val safePoint: Int? = null,
    @Serializable(with = SceneMpTypeContainerSerializer::class)
    val mpType: EnumWrapper<SceneMpType>? = null,
    val isAllowMapMarkPoint: Boolean? = null,
    val isDeleteMapMarkPoint: Boolean? = null,
    val dungeonEntryPoint: List<Int>? = null,
    val imageSceneId: Int? = null,

    // Server only
    val navmeshModeString: String? = null,
    @JsonNames("is_check_output_config")
    val checkLevelOutputConfig: Boolean? = null,
    val isBlockBinAbandoned: Boolean? = null,
    val isSceneBinAbandoned: Boolean? = null,

    // Client only
    val scriptData: String? = null,
) : IntKey {
    override fun getIntKey() = id

    fun getTypeNonNull() = type?.value ?: SceneType.SCENE_NONE
}
