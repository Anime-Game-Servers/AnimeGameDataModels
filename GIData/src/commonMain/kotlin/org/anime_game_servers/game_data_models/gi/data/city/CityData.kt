@file:OptIn(ExperimentalSerializationApi::class)

package org.anime_game_servers.game_data_models.gi.data.city

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.helpers.nullableEnumValueOfOrDefault
import org.anime_game_servers.game_data_models.gi.data.general.*
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * This contains info about the regions (cities), their areas and some more
 */
@DataFile("ExcelBinOutput/CityConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/CityData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class CityData(
    val sceneId: Int = 3,
    val cityId: Int,
    @JsonNames("areaIdVec")
    val areaIds: List<Int>,
    @SerialName("openState")
    val openStateString: String? = null,
    @Transient
    val openState: OpenState? = nullableEnumValueOfOrDefault(openStateString, OpenState.OPEN_STATE_UNKNOWN),

    // Client only
    val mapPosX: Int = UnsetInt,
    val mapPosY: Int = UnsetInt,
    val zoomForExploration: Float = UnsetFloat,
    val adventurePointId: Int = UnsetInt,
    @JsonNames("ExpeditionMap")
    val expeditionMap: String? = null,
    @JsonNames("ExpeditionWaterMark")
    val expeditionWaterMark: String? = null,

    val cityNameTextMapHash: TextMapHash = UnsetTextMap,
    val cityGoddnessNameTextMapHash: TextMapHash = UnsetTextMap,
    val cityGoddnessDescTextMapHash: TextMapHash = UnsetTextMap,
    ) : IntKey {
    override fun getIntKey() = cityId
}
