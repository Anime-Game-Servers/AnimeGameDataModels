package org.anime_game_servers.game_data_models.gi.data.scene.weather

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.game_data_models.gi.helpers.nullableEnumValueOfOrDefault
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * TODO Add documentation
 * These are known names for files handled by this class:
 * ExcelBinOutput/WeatherExcelConfigData.json
 * txt/WeatherData.txt (with an appropriate parser)
 */
@DataFile("ExcelBinOutput/WeatherExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/WeatherData.txt", FileType.TSV, FolderType.EXCEL)
@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class WeatherData(
    val areaID: Int,
    val weatherAreaId: Int = UnsetInt,
    @JsonNames("maxHeightStr")
    val maxHeightStr: String? = null,
    val maxHeight: Int = if(maxHeightStr?.isNotBlank() == true) maxHeightStr.toInt() else UnsetInt,
    val gadgetID: Int = UnsetInt,
    val isDefaultValid: Boolean? = null,
    val templateName: String? = null,
    val priority: Int = UnsetInt,
    val profileName: String? = null,
    @SerialName("defaultClimate")
    val defaultClimateString: String? = null,
    @Transient
    val defaultClimate: ClimateType? = nullableEnumValueOfOrDefault(defaultClimateString, CLIMATE_UNKNOWN),

    val isUseDefault: Boolean? = null,
    val sceneID: Int = UnsetInt,
) : IntKey {
    override fun getIntKey() = areaID

    fun hasWeatherAreaId() = weatherAreaId > 0
    fun hasMaxHeight() = maxHeight > 0
    fun hasGadgetId() = gadgetID > 0
    fun hasDefaultValid() = defaultClimateString != null
    fun hasDefaultClimate() = defaultClimate != null
    fun hasTemplateName() = !templateName.isNullOrBlank()
    fun hasPriority() = priority > 0

    fun getIsDefaultValid() = isDefaultValid ?: false
    fun getIsUseDefault() = isUseDefault ?: false

}
