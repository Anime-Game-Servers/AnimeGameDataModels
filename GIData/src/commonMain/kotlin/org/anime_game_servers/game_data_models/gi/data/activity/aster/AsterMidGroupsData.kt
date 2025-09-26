package org.anime_game_servers.game_data_models.gi.data.activity.aster

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * TODO: Documentation
 * These are known names for files handled by this class:
 * ExcelBinOutput/AsterMidGroupsExcelConfigData.json
 * txt/AsterMidGroupsData.txt (with an appropriate parser)
 * @property id TODO
 * @property groupId TODO
 * @property battleGroupVec TODO
 */
@DataFile("ExcelBinOutput/AsterMidGroupsExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/AsterMidGroupsData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class AsterMidGroupsData(
    val id: Int,
    val groupId: Int = UnsetInt,
    val battleGroupVec: List<Int>? = null,
) : IntKey {
    override fun getIntKey() = id
}
