package org.anime_game_servers.game_data_models.gi.data.world

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType
import org.anime_game_servers.game_data_models.loader.enums.EnumWrapper

/**
 * This contains information about the main scenes for a world
 * @param id The id of the world instance
 * @param type The type of the world instance
 * @param mainSceneId The id of the main scene of the world
 * @param subSceneIdVec A list of scenes that are sub scenes to the main scene
 */
@DataFile("ExcelBinOutput/WorldExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/WorldData.txt", FileType.TSV, FolderType.EXCEL)
@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class WorldData(
    val id: Int,
    @Serializable(with = WorldTypeContainerSerializer::class)
    val type: EnumWrapper<WorldType>? = null,
    @JsonNames("main_scene_id")
    val mainSceneId: Int,
    @JsonNames("sub_scene_id_vec")
    val subSceneIdVec: List<Int>,
) : IntKey {
    override fun getIntKey() = id
}
