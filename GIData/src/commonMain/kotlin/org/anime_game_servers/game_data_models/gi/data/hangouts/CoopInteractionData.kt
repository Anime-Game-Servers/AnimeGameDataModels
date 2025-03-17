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
 * ExcelBinOutput/CoopInteractionExcelConfigData.json
 * txt/CoopInteractionData*.txt (with an appropriate parser)
 */
@DataFile("ExcelBinOutput/CoopInteractionExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/CoopInteractionData*.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class CoopInteractionData(
    val id:Int,
    val npcId: Int = UnsetInt,
    val mainQuestId: Int = UnsetInt,
    val priority: Int = UnsetInt,
    val isAuto: Boolean? = null,
    ) : IntKey {
    override fun getIntKey() = id
}
