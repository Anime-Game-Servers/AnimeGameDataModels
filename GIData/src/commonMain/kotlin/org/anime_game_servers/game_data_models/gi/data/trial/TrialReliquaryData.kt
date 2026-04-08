@file:OptIn(ExperimentalSerializationApi::class)

package org.anime_game_servers.game_data_models.gi.data.trial

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * TODO
 * These are known names for files handled by this class:
 * ExcelBinOutput/TrialReliquaryExcelConfigData.json
 * txt/TrialReliquaryData.txt (with an appropriate parser)
 * @property id TODO
 * @property reliquaryId TODO
 * @property level TODO
 * @property mainPropId TODO
 * @property appendPropList TODO
 */
@DataFile("ExcelBinOutput/TrialReliquaryExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/TrialReliquaryData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class TrialReliquaryData(
    @JsonNames("Id")
    val id: Int,
    @JsonNames("ReliquaryId")
    val reliquaryId: Int = UnsetInt,
    @JsonNames("Level")
    val level: Int = UnsetInt,
    @JsonNames("MainPropId")
    val mainPropId: Int = UnsetInt,
    @JsonNames("AppendPropList")
    val appendPropList: List<Int>? = null,
) : IntKey {
    override fun getIntKey() = id
}
