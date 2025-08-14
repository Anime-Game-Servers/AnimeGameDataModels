@file:OptIn(ExperimentalSerializationApi::class)

package org.anime_game_servers.game_data_models.gi.data.city

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * TODO
 */
@DataFile("ExcelBinOutput/CityTaskOpenExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/CityTaskOpenData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class CityTaskOpenData(
    val cityId: Int,
    val questId: Int,
    val cityGuaranteedPool: List<Int>? = null,
    ) : IntKey {
    override fun getIntKey() = cityId

}
