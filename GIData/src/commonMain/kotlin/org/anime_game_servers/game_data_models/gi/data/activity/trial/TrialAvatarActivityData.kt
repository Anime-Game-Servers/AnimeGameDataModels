@file:OptIn(ExperimentalSerializationApi::class)

package org.anime_game_servers.game_data_models.gi.data.activity.trial

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * TODO
 * These are known names for files handled by this class:
 * ExcelBinOutput/TrialAvatarActivityExcelConfigData.json
 * txt/TrialAvatarActivity.txt (with an appropriate parser)
 * @property scheduleId TODO
 * @property avatarIndexIdList TODO
 * @property rewardIdList TODO
 */
@DataFile("ExcelBinOutput/TrialAvatarActivityExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("Server/TrialAvatar/TrialAvatarActivityExcelConfigData.json", FileType.JSON, FolderType.CUSTOM)
@DataFile("txt/TrialAvatarActivity.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class TrialAvatarActivityData(
    @JsonNames("ScheduleId")
    val scheduleId: Int,
    @JsonNames("AvatarIndexIdList")
    val avatarIndexIdList: List<Int>? = null,
    @JsonNames("RewardIdList")
    val rewardIdList: List<Int>? = null,
) : IntKey {
    override fun getIntKey() = scheduleId
}
