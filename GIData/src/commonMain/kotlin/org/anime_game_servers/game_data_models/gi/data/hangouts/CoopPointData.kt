package org.anime_game_servers.game_data_models.gi.data.hangouts

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.*
import org.anime_game_servers.game_data_models.gi.helpers.getValueNonNull
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType
import org.anime_game_servers.game_data_models.loader.enums.EnumWrapper

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
    @Serializable(with = CoopPointTypeContainerSerializer::class)
    val type: EnumWrapper<CoopPointType>? = null,

    //TextMapHash
    val pointNameTextMapHash: TextMapHash = UnsetTextMap,
    val pointDecTextMapHash: TextMapHash = UnsetTextMap,
    val photoMaleHash: TextHash = UnsetTextHash,
    val photoFemaleHash: TextHash = UnsetTextHash,
    ) : IntKey {
    override fun getIntKey() = id
    fun getTypeNonNull() = type.getValueNonNull(CoopPointTypeMetadata)
}
