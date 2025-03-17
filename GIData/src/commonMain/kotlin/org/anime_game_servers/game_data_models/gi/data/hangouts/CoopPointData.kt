package org.anime_game_servers.game_data_models.gi.data.hangouts

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.*
import org.anime_game_servers.game_data_models.gi.helpers.nullableEnumValueOfOrDefault
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * TODO
 * These are known names for files handled by this class:
 * ExcelBinOutput/CoopPointExcelConfigData.json
 * txt/CoopPointData.txt (with an appropriate parser)
 */
@DataFile("ExcelBinOutput/CoopPointExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/CoopPointData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class CoopPointData(
    val id:Int,
    val chapterId: Int = UnsetInt,
    val acceptQuest: Int = UnsetInt,
    val postPointList: List<Int>? = null,
    val pointPosId: Int = UnsetInt,
    @SerialName("type")
    val typeString: String? = null,
    @Transient
    val type: CoopPointType? = nullableEnumValueOfOrDefault(typeString, CoopPointType.POINT_UNKNOWN),

    //TextMapHash
    val pointNameTextMapHash: TextMapHash = UnsetTextMap,
    val pointDecTextMapHash: TextMapHash = UnsetTextMap,
    val photoMaleHash: TextMapHash = UnsetTextMap,
    val photoFemaleHash: TextMapHash = UnsetTextMap,
    ) : IntKey {
    override fun getIntKey() = id
}
