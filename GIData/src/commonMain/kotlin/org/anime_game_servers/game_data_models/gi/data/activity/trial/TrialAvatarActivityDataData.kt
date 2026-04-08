@file:OptIn(ExperimentalSerializationApi::class)

package org.anime_game_servers.game_data_models.gi.data.activity.trial

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.TextMapHash
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.gi.data.general.UnsetTextMap
import org.anime_game_servers.game_data_models.gi.data.watcher.WatcherTriggerConfig
import org.anime_game_servers.game_data_models.gi.serializers.CStringToIntListSerializer
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * TODO
 * These are known names for files handled by this class:
 * ExcelBinOutput/TrialAvatarActivityDataExcelConfigData.json
 * txt/TrialAvatarActivityData.txt (with an appropriate parser)
 * @property id TODO
 * @property trialAvatarIndexId TODO
 * @property trialAvatarId TODO
 * @property dungeonId TODO
 * @property battleAvatarsList TODO
 * @property firstPassReward TODO
 * @property triggerConfig TODO
 * @property progress TODO
 * @property titleTextMapHash TODO
 * @property briefInfoTextMapHash TODO
 */
@DataFile("ExcelBinOutput/TrialAvatarActivityDataExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/TrialAvatarActivityData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class TrialAvatarActivityDataData(
    val id: Int,
    val trialAvatarIndexId: Int = UnsetInt,
    val trialAvatarId: Int = UnsetInt,
    val dungeonId: Int = UnsetInt,
    @Serializable(with = CStringToIntListSerializer::class)
    val battleAvatarsList: List<Int>? = null,
    val firstPassReward: Int = UnsetInt,
    val triggerConfig: WatcherTriggerConfig? = null,
    val progress: Int = UnsetInt,

    // TextMapHashes
    val titleTextMapHash: TextMapHash = UnsetTextMap,
    val briefInfoTextMapHash: TextMapHash = UnsetTextMap,
) : IntKey {
    override fun getIntKey() = id
}
