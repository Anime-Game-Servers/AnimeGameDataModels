package org.anime_game_servers.game_data_models.gi.data.scene

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.game_data_models.gi.data.general.Element
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.ElementContainerSerializer
import org.anime_game_servers.game_data_models.gi.data.general.ElementMetadata
import org.anime_game_servers.game_data_models.gi.data.general.UnsetFloat
import org.anime_game_servers.game_data_models.gi.helpers.getValueNonNull
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType
import org.anime_game_servers.game_data_models.loader.enums.EnumWrapper

/**
 *
 */
@DataFile("ExcelBinOutput/WorldAreaConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/WorldAreaData*.txt", FileType.TSV, FolderType.EXCEL)
@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class WorldAreaConfigData(
    @JsonNames("ID")
    val id: Int,
    @JsonNames("SceneID", "SceneId", "sceneID", "scene_id")
    val sceneId: Int,
    @JsonNames("AreaType", "area_type")
    @Serializable(with = WorldAreaTypeContainerSerializer::class)
    val areaType: EnumWrapper<WorldAreaType>? = null,
    @JsonNames("AreaID1", "AreaId1", "areaID1", "area_id_1")
    val areaId1: Int,
    @JsonNames("AreaID2", "AreaId2", "areaID2", "area_id_2")
    val areaId2: Int = UnsetInt,
    @JsonNames("AreaDefaultLock", "area_default_lock")
    val areaDefaultLock: Boolean? = null,
    @JsonNames("tower_point_id")
    val towerPointId: Int = UnsetInt,
    @JsonNames("element_type")
    @Serializable(with = ElementContainerSerializer::class)
    val elementType: EnumWrapper<Element>? = null,
    @JsonNames("TerrainType", "terrain_type")
    @Serializable(with = AreaTerrainTypeContainerSerializer::class)
    val terrainType: EnumWrapper<AreaTerrainType>? = null,
    @JsonNames("show_tips")
    val showTips: Boolean? = null,
    @JsonNames("minimap_scale")
    val minimapScale: Float = UnsetFloat,
) : IntKey {
    override fun getIntKey() = id

    fun getElementTypeNonNull() = elementType.getValueNonNull(ElementMetadata)
}
