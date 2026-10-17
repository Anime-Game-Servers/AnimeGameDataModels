@file:OptIn(ExperimentalSerializationApi::class)

package org.anime_game_servers.game_data_models.gi.data.dungeon

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
 * ExcelBinOutput/DungeonSerialConfigData.json
 * txt/DungeonSerialData.txt (with an appropriate parser)
 */
@DataFile("ExcelBinOutput/DungeonSerialConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/DungeonSerialData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class DungeonSerialData(
    val id: Int,
    @JsonNames("MaxTakeNum")
    val maxTakeNum: Int = UnsetInt,
    val takeCost: Int = UnsetInt,
) : IntKey {
    override fun getIntKey() = id
}
