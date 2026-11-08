@file:OptIn(ExperimentalSerializationApi::class)

package org.anime_game_servers.game_data_models.gi.data.rewards

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.gi.helpers.getNonNull
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType
import kotlin.jvm.JvmStatic

/**
 * These are the rewards for unlocking specific scene points in the game.
 * These are known names for files handled by this class:
 * ExcelBinOutput/TransPointRewardConfigData.json
 * txt/TransPointRewardData.txt (with an appropriate parser)
 * @property sceneId id of the scene in which the point got unlocked, and in which the area will be unlocked
 * @property pointId id of the point in scene [sceneId] to unlock
 * @property rewardId id of the reward found in [RewardData]
 * @property unlockAreaId id of the area to unlock
 * @property notificationGroupId TODO what is this
 */
@DataFile("ExcelBinOutput/TransPointRewardConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/TransPointRewardData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class TransPointRewardData(
    val sceneId: Int,
    val pointId: Int,
    val rewardId: Int = UnsetInt,
    val unlockAreaId: List<Int>? = null,
    @JsonNames("groupIdVec")
    val notificationGroupId: List<Int>? = null,
) : IntKey {
    override fun getIntKey() = getKey(sceneId, pointId)

    fun hasRewardId() = rewardId != UnsetInt
    fun getUnlockAreaIdNonNull() = unlockAreaId.getNonNull()
    fun getNotificationGroupIdNonNull() = notificationGroupId.getNonNull()

    companion object {
        @JvmStatic
        fun getKey(sceneId: Int, pointId: Int) = (pointId shl 8) + sceneId
    }
}
