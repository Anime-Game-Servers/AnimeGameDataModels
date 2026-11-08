@file:OptIn(ExperimentalSerializationApi::class)

package org.anime_game_servers.game_data_models.gi.data.dungeon

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.gi.serializers.StringToLocalDatetimeSerializer
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType
import org.anime_game_servers.game_data_models.loader.enums.EnumWrapper

/**
 * TODO
 * These are known names for files handled by this class:
 * ExcelBinOutput/DungeonRosterConfigData.json
 * txt/DungeonRosterData.txt (with an appropriate parser)
 */
@DataFile("ExcelBinOutput/DungeonRosterConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/DungeonRosterData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class DungeonRosterData(
    val id: Int,
    val cycleTime: Int = UnsetInt,
    val rosterPool: List<RosterPool>? = null,

    @Serializable(with = DungeonRosterCycleTypeContainerSerializer::class)
    val cycleType: EnumWrapper<DungeonRosterCycleType>? = null,

    @Serializable(with = StringToLocalDatetimeSerializer::class)
    @JsonNames("openTimeStr")
    val openTime: LocalDateTime? = null,
) : IntKey {
    override fun getIntKey() = id

    @Serializable
    data class RosterPool(
        val dungeonList: List<Int>
    )
}
