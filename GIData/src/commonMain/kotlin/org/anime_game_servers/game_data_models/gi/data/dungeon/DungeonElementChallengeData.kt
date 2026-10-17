package org.anime_game_servers.game_data_models.gi.data.dungeon

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * TODO
 * These are known names for files handled by this class:
 * ExcelBinOutput/DungeonElementChallengeExcelConfigData.json
 * txt/DungeonElementChallengeData.txt (with an appropriate parser)
 */
@DataFile("ExcelBinOutput/DungeonElementChallengeExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/DungeonElementChallengeData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class DungeonElementChallengeData(
    val dungeonId: Int,
    val trialAvatarId: List<Int>? = null,


    // Client only
    val tutorialId: Int = UnsetInt,
) : IntKey {
    override fun getIntKey() = dungeonId
}
