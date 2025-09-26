package org.anime_game_servers.game_data_models.gi.data.activity.aster

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.TextMapHash
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * TODO: Documentation
 * These are known names for files handled by this class:
 * ExcelBinOutput/AsterMidExcelConfigData.json
 * txt/AsterMidData.txt (with an appropriate parser)
 * @property id TODO
 * @property campVec TODO
 */
@DataFile("ExcelBinOutput/AsterMidExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/AsterMidData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class AsterMidData(
    val id: Int,
    val campVec: List<Int>? = null,
) : IntKey {
    override fun getIntKey() = id
}
