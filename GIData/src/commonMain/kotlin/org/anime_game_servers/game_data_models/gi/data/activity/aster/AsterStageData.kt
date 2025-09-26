package org.anime_game_servers.game_data_models.gi.data.activity.aster

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
 * ExcelBinOutput/AsterStageExcelConfigData.json
 * txt/AsterStageData.txt (with an appropriate parser)
 * @property id TODO
 * @property activityId TODO
 * @property chapterId TODO
 * @property openday TODO
 * @property openQuestId TODO
 * @property questIdList TODO
 * @property titleTextMapHash TODO
 * @property stageNameTextMapHash TODO
 * @property introTextMapHash TODO
 * @property storyTextMapHash TODO
 */
@DataFile("ExcelBinOutput/AsterStageExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/AsterStageData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class AsterStageData(
    val id: Int,
    val activityId: Int = UnsetInt,
    val chapterId: Int = UnsetInt,
    val openday: Int = UnsetInt,
    val openQuestId: Int = UnsetInt,
    val questIdList: List<Int>? = null,

    // Server only
    val titleText: String? = null,
    val stageNameText: String? = null,
    val introText: String? = null,
    val storyNameText: String? = null,

    // TextMapHashes
    val titleTextMapHash: TextMapHash = UnsetTextMap,
    val stageNameTextMapHash: TextMapHash = UnsetTextMap,
    val introTextMapHash: TextMapHash = UnsetTextMap,
    val storyTextMapHash: TextMapHash = UnsetTextMap,
) : IntKey {
    override fun getIntKey() = id
}
