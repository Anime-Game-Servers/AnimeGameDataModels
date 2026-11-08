package org.anime_game_servers.game_data_models.gi.data.hangouts

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.*
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType
import org.anime_game_servers.game_data_models.loader.enums.EnumWrapper

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
    @Serializable(with = CoopCGTypeContainerSerializer::class)
    val cgType: EnumWrapper<CoopCGType>? = null,
    val unlockCond: List<CoopCondConfig>? = null,
    val showImageHash: TextHash = UnsetTextHash,
    val showImageSmallHash: TextHash = UnsetTextHash,

    //TextMapHash
    val cgNameTextMapHash: TextMapHash = UnsetTextMap,
    val cgDesTextMapHash: TextMapHash = UnsetTextMap,
    ) : IntKey {
    override fun getIntKey() = id
}
