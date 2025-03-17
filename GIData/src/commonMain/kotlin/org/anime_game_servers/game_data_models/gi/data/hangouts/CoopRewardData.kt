package org.anime_game_servers.game_data_models.gi.data.hangouts

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.*
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * TODO
 * These are known names for files handled by this class:
 * ExcelBinOutput/CoopRewardExcelConfigData.json
 * txt/CoopRewardData.txt (with an appropriate parser)
 */
@DataFile("ExcelBinOutput/CoopRewardExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/CoopRewardData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class CoopRewardData(
    val id:Int,
    val rewardCond: List<CoopCondConfig>? = null,
    val chapterId: Int = UnsetInt,
    val rewardId: Int = UnsetInt,
    val sortId: Int = UnsetInt,

    //TextMapHash
    val condTipTextMapHash: TextMapHash = UnsetTextMap,
    val condTipDesTextMapHash: TextMapHash = UnsetTextMap,
    ) : IntKey {
    override fun getIntKey() = id
}
