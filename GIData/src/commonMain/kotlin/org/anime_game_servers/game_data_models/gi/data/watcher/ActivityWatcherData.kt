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
 * ExcelBinOutput/ActivityWatcherConfigData.json (deprecated)
 * ExcelBinOutput/NewActivityWatcherConfigData.json
 * txt/NewActivityWatcherData.txt (with an appropriate parser)
 */
@DataFile("ExcelBinOutput/ActivityWatcherConfigData.json", FileType.JSON, FolderType.EXCEL_DEPRECATED)
@DataFile("ExcelBinOutput/NewActivityWatcherConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/NewActivityWatcherData.txt", FileType.TSV, FolderType.EXCEL)
@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class ActivityWatcherData(
    @JsonNames("Id")
    override val id: Int,
    @JsonNames("TriggerConfig", "trigger_config")
    override val triggerConfig: WatcherTriggerConfig? = null,
    @JsonNames("Progress")
    override val progress: Int = UnsetInt,
    @JsonNames("isDisuse", "is_disuse")
    override val isObsolete: Boolean? = null,

    @JsonNames("RewardId")
    val rewardId: Int = UnsetInt,
    @JsonNames("RewardPreview")
    val rewardPreview: Int = UnsetInt,
    val isAutoGrant: Boolean? = null,

    @JsonNames("ActivitychallengetipsTextMapHash")
    val activitychallengetipsTextMapHash: TextMapHash = UnsetTextMap,
    @JsonNames("ExtraActivitychallengetipsTextMapHash")
    val extraActivitychallengetipsTextMapHash: TextMapHash = UnsetTextMap,
) : WatcherData
