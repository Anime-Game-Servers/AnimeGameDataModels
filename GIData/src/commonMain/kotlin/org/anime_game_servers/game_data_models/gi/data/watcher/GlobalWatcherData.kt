@file:OptIn(ExperimentalSerializationApi::class)

package org.anime_game_servers.game_data_models.gi.data.watcher

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * TODO Add documentation
 * These are known names for files handled by this class:
 * ExcelBinOutput/GlobalWatcherConfigData.json
 * txt/GlobalWatcherData.txt (with an appropriate parser)
 */
@DataFile("ExcelBinOutput/GlobalWatcherConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/GlobalWatcherData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class GlobalWatcherData(
    override val id: Int,
    override val triggerConfig: WatcherTriggerConfig? = null,
    override val progress: Int = UnsetInt,
    @JsonNames("isDisuse")
    override val isObsolete: Boolean? = null,
    val predicateConfigs: List<PredicateConfig>? = null,
) : WatcherData
