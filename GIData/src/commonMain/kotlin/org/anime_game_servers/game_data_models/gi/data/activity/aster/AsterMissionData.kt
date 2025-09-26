package org.anime_game_servers.game_data_models.gi.data.activity.aster

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.TextHash
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.gi.data.general.UnsetTextHash
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * TODO: Documentation
 * These are known names for files handled by this class:
 * ExcelBinOutput/AsterMissionExcelConfigData.json
 * txt/AsterMissionData.txt (with an appropriate parser)
 * @property missionId TODO
 * @property phase TODO
 * @property watcherId TODO
 * @property transPointId TODO
 * @property tracePoint TODO
 * @property perfabPathHashSuffix TODO
 */
@DataFile("ExcelBinOutput/AsterMissionExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/AsterMissionData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class AsterMissionData(
    val missionId: Int,
    val phase: Int = UnsetInt,
    val watcherId: Int = UnsetInt,
    // client only
    val transPointId: Int = UnsetInt,
    val tracePoint: String? = null,
    val perfabPathHashSuffix: TextHash = UnsetTextHash,
) : IntKey {
    override fun getIntKey() = missionId
}
