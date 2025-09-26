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
 * ExcelBinOutput/AsterLittleExcelConfigData.json
 * txt/AsterLittleData.txt (with an appropriate parser)
 * @property stageId id if the aster little stage
 * @property nextStageIdVec stage to unlock after completing this stage
 * @property openDay on which day of the event this stage opens
 * @property missionVec which [AsterMissionData] this aster little stage contains
 * @property watcherIdVec TODO
 * @property titleTextMapHash TODO
 * @property descTextMapHash TODO
 */
@DataFile("ExcelBinOutput/AsterLittleExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/AsterLittleData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class AsterLittleData(
    val stageId: Int,
    val nextStageIdVec: List<Int>? = null,
    val openDay: Int = UnsetInt,
    val missionVec: List<Int>? = null,
    val watcherIdVec: List<Int>? = null,

    // TextMaps
    val titleTextMapHash: TextMapHash = UnsetTextMap,
    val descTextMapHash: TextMapHash = UnsetTextMap,
) : IntKey {
    override fun getIntKey() = stageId
}
