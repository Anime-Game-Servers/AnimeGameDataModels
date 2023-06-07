@file:OptIn(ExperimentalSerializationApi::class)

package org.anime_game_servers.game_data_models.data.watcher

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.game_data_models.data.general.UnsetInt

/**
 * TODO Add documentation
 * These are known names for files handled by this class:
 * ExcelBinOutput/GlobalWatcherConfigData.json
 * txt/GlobalWatcherData.txt (with an appropriate parser)
 */
@Serializable
data class GlobalWatcherData(
    override val id: Int,
    override val triggerConfig: WatcherTriggerConfig? = null,
    override val progress: Int = UnsetInt,
    @JsonNames("isObsolete", "isDisuse")
    override val isObsolete: Boolean? = null,
    val predicateConfigs: List<PredicateConfig>? = null,
) : WatcherData
