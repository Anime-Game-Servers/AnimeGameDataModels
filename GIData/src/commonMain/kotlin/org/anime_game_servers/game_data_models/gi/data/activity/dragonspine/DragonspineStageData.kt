package org.anime_game_servers.game_data_models.gi.data.activity.dragonspine

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.TextMapHash
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.gi.data.general.UnsetTextMap
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * TODO: Documentation
 * These are known names for files handled by this class:
 * ExcelBinOutput/DragonSpineStageExcelConfigData.json
 * txt/DragonSpineStageData.txt (with an appropriate parser)
 * @property id TODO
 * @property chapterId TODO
 * @property coinIdList TODO
 * @property openday TODO
 * @property preQuestId TODO
 * @property missionIdList TODO
 * @property rewardPreviewId TODO
 * @property descTextMapHash TODO
 */
@DataFile("ExcelBinOutput/DragonSpineStageExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/DragonSpineStageData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class DragonspineStageData(
    val id: Int,
    val chapterId: Int = UnsetInt,
    val coinIdList: List<Int>? = null,
    val openday: Int = UnsetInt,
    val preQuestId: Int = UnsetInt,
    val missionIdList: List<Int>? = null,
    val rewardPreviewId: Int = UnsetInt,

    // TextMapHashes
    val descTextMapHash: TextMapHash = UnsetTextMap,
) : IntKey {
    override fun getIntKey() = id
}
