package org.anime_game_servers.game_data_models.gi.data.rewards

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType
import kotlin.jvm.JvmStatic

/**
 * This Contains the reward references for different levels of success in the spiral abyss (tower)
 * The rewardsId referenced in this class is found in [RewardData]
 * These are known names for files handled by this class:
 * ExcelBinOutput/TowerRewardExcelConfigData.json
 * txt/TowerRewardData.txt (with an appropriate parser)
 * @property rewardGroup id of the reward found in [RewardData]
 * @property floor the level the  of the tower the player did. 1-8 are the abyss corridor and normally stay the same.
 * 9-12 are the moon spire and change every from time to time
 * @property threeStarReward the rewardId in [RewardData] for getting 3 stars on the floor
 * @property sixStarReward the rewardId in [RewardData] for getting 6 stars on the floor
 * @property nineStarReward the rewardId in [RewardData] for getting 9 stars on the floor
 * @property chamberReward the rewardId in [RewardData] for completing each chamber. e.g. index 0 is for chamber 1
 */
@DataFile("ExcelBinOutput/TowerRewardExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/TowerRewardData.txt", FileType.TSV, FolderType.EXCEL)
@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class TowerRewardData(
    @JsonNames("reward_group", "levelIndex")
    val rewardGroup: Int,
    @JsonNames("reward_id3_stars", "rewardId3Stars", "floorIndex")
    val floor: Int,
    @JsonNames("reward_id3_stars", "rewardId3Stars", "threeStarsReward")
    val threeStarReward: Int,
    @JsonNames("reward_id6_stars", "rewardId6Stars", "sixStarsReward")
    val sixStarReward: Int,
    @JsonNames("reward_id9_stars", "rewardId9Stars", "nineStarsReward")
    val nineStarReward: Int,
    @JsonNames("reward_id_room", "rewardIdRoom", "chamberBountyRewards")
    val chamberRewards: List<Int>
) : IntKey {
    override fun getIntKey() = getKey(rewardGroup, floor)

    companion object {
        @JvmStatic
        fun getKey(rewardGroup: Int, floor: Int) = (rewardGroup shl 8) + floor
    }
}
