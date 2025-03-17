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
 * ExcelBinOutput/CoopChapterExcelConfigData.json
 * txt/CoopChapterData.txt (with an appropriate parser)
 */
@DataFile("ExcelBinOutput/CoopChapterExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/CoopChapterData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class CoopChapterData(
    val id:Int,
    val avatarId: Int = UnsetInt,
    val chapterSortId: Int = UnsetInt,
    val avatarSortId: Int = UnsetInt,
    val chapterIcon: String? = null,
    val unlockCond: List<CoopCondConfig>? = null,
    val unlockCondTips: List<Int>? = null,
    val openMaterialId: Int = UnsetInt,
    val openMaterialNum: Int = UnsetInt,
    val beginTimeStr: String? = null,
    val confidenceValue: Int = UnsetInt,
    val pointGraphPath: String? = null,
    val graphXRatio: Float = UnsetFloat,
    val graphYRatio: Float = UnsetFloat,

    //TextMapHash
    val chapterNameTextMapHash: TextMapHash = UnsetTextMap,
    val coopPageTitleTextMapHash: TextMapHash = UnsetTextMap,
    ) : IntKey {
    override fun getIntKey() = id
}
