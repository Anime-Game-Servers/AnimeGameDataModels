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
 * ExcelBinOutput/CoopCGExcelConfigData.json
 * txt/CoopCGData.txt (with an appropriate parser)
 */
@DataFile("ExcelBinOutput/CoopCGExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/CoopCGData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class CoopCgData(
    val id:Int,
    val chapterId: Int = UnsetInt,
    val unlockPointId: Int = UnsetInt,
    val sortId: Int = UnsetInt,
    @SerialName("cgType")
    val cgTypeString: String? = null,
    @Transient
    val cgType: CoopCGType? = nullableEnumValueOfOrDefault(cgTypeString, CoopCGType.CG_TYPE_UNKNOWN),
    val unlockCond: List<CoopCondConfig>? = null,
    val showImageHash: Long = UnsetLong,
    val showImageSmallHash: Long = UnsetLong,

    //TextMapHash
    val cgNameTextMapHash: TextMapHash = UnsetTextMap,
    val cgDesTextMapHash: TextMapHash = UnsetTextMap,
    ) : IntKey {
    override fun getIntKey() = id
}
