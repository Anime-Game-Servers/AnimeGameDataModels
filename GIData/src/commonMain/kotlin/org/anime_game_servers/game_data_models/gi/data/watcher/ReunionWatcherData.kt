package org.anime_game_servers.game_data_models.gi.data.watcher

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.game_data_models.gi.data.general.TextMapHash
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.gi.data.general.UnsetTextMap
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * TODO Add documentation
 * These are known names for files handled by this class:
 * ExcelBinOutput/ReunionWatcherExcelConfigData.json
 * txt/ReunionWatcherData.txt (with an appropriate parser)
 * @property activateLevelRange comma separated list of two integers: minimum level and maximum level
 * @property daysForReward number of days to wait before allowing the player to claim the watcher reward
 */
@DataFile("ExcelBinOutput/ReunionWatcherExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/ReunionWatcherData.txt", FileType.TSV, FolderType.EXCEL)
@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class ReunionWatcherData(
    override val id: Int,
    override val triggerConfig: WatcherTriggerConfig? = null,
    override val progress: Int = UnsetInt,
    @JsonNames("isDisuse")
    override val isObsolete: Boolean? = null,

    val watcherGroupId: Int = UnsetInt,
    val activateLevelRange: String? = null,
    val rewardId: Int = UnsetInt,
    val score: Int = UnsetInt,
    @JsonNames("reward_unlock_day", "rewardUnlockDay")
    val daysForReward: Int = UnsetInt,


    val descTextMapHash: TextMapHash = UnsetTextMap,
) : WatcherData
