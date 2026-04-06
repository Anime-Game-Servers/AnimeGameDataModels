package org.anime_game_servers.game_data_models.gi.data.scene.weather

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import org.anime_game_servers.core.base.interfaces.StringKey
import org.anime_game_servers.game_data_models.gi.data.general.UnsetFloat
import org.anime_game_servers.game_data_models.gi.helpers.enumValueOfOrDefault
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType
import kotlin.jvm.JvmStatic

/**
 * TODO Add documentation
 * These are known names for files handled by this class:
 * ExcelBinOutput/WeatherTemplateExcelConfigData.json
 * txt/WeatherTemplate.txt (with an appropriate parser)
 */
@DataFile("ExcelBinOutput/WeatherTemplateExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/WeatherTemplate.txt", FileType.TSV, FolderType.EXCEL)
@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class WeatherTemplateData(
    val templateName: String,
    @SerialName("weatherType")
    val weatherTypeString: String,
    @Transient
    val weatherType: ClimateType = enumValueOfOrDefault(weatherTypeString, CLIMATE_UNKNOWN),
    val sunnyProb: Float = UnsetFloat,
    val cloudyProb: Float = UnsetFloat,
    val rainProb: Float = UnsetFloat,
    val thunderstormProb: Float = UnsetFloat,
    val snowProb: Float = UnsetFloat,
    val mistProb: Float = UnsetFloat,
) : StringKey {
    override fun getStringKey() = getKey(templateName, weatherType)

    fun hasSunnyProb() = sunnyProb >= 0f
    fun hasCloudyProb() = cloudyProb >= 0f
    fun hasRainProb() = rainProb >= 0f
    fun hasThunderstormProb() = thunderstormProb >= 0f
    fun hasSnowProb() = snowProb >= 0f
    fun hasMistProb() = mistProb >= 0f

    fun sunnyProb() = if(hasSunnyProb()) sunnyProb else 0f
    fun cloudyProb() = if(hasCloudyProb()) cloudyProb else 0f
    fun rainProb() = if(hasRainProb()) rainProb else 0f
    fun thunderstormProb() = if(hasThunderstormProb()) thunderstormProb else 0f
    fun snowProb() = if(hasSnowProb()) snowProb else 0f
    fun mistProb() = if(hasMistProb()) mistProb else 0f

    companion object {
        @JvmStatic
        fun getKey(templateName: String, weatherType: ClimateType) = templateName+weatherType.name
    }
}
