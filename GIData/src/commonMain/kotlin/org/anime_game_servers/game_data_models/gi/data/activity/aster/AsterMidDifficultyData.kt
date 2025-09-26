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
 * ExcelBinOutput/AsterMidDifficultyExcelConfigData.json
 * txt/AsterMidDifficultyData.txt (with an appropriate parser)
 * @property id TODO
 * @property worldLevelVec TODO
 * @property dropId TODO
 * @property rewardId TODO
 * @property resin TODO
 * @property recommendLevel TODO
 * @property monsterLevel TODO
 */
@DataFile("ExcelBinOutput/AsterMidDifficultyExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/AsterMidDifficultyData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class AsterMidDifficultyData(
    val id: Int,
    val worldLevelVec: List<Int>? = null,
    val dropId: Int = UnsetInt,
    val rewardId: Int = UnsetInt,
    val resin: Int = UnsetInt,
    val recommendLevel: Int = UnsetInt,
    val monsterLevel: Int = UnsetInt,
) : IntKey {
    override fun getIntKey() = id
}
