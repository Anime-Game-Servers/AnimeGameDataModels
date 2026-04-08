@file:OptIn(ExperimentalSerializationApi::class)

package org.anime_game_servers.game_data_models.gi.data.trial

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.gi.helpers.nullableEnumValueOfOrDefault
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * TODO
 * These are known names for files handled by this class:
 * ExcelBinOutput/TrialAvatarFetterDataConfigData.json
 * @property scheduleId TODO
 * @property avatarIndexIdList TODO
 * @property rewardIdList TODO
 */
@DataFile("ExcelBinOutput/TrialAvatarFetterDataConfigData.json", FileType.JSON, FolderType.EXCEL)
@Serializable
data class TrialAvatarFetterData(
    val avatarId: Int,
    val fetterId: Int = UnsetInt,
    val finishCond: TrialAvatarFetterCondition? = null,
) : IntKey {
    override fun getIntKey() = avatarId

    @Serializable
    data class TrialAvatarFetterCondition(
        val condTypeString: String,
        val condType: TrialAvatarFetterConditionType? = nullableEnumValueOfOrDefault(condTypeString, TRIAL_FETTER_CONDITION_UNKNOWN),
        val paramList: List<Int>? = null,
    )
}
