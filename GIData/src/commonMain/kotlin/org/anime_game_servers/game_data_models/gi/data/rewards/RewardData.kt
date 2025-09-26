package org.anime_game_servers.game_data_models.gi.data.rewards

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.gi.data.quest.GainItem
import org.anime_game_servers.game_data_models.gi.data.quest.MainQuestData
import org.anime_game_servers.game_data_models.gi.data.watcher.ReunionWatcherData
import org.anime_game_servers.game_data_models.gi.data.watcher.ActivityWatcherData
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * This Contains all information about item rewards gained though multiple means.
 * Some example of models making use of this class are [TransPointRewardData], [MainQuestData].
 * [ReunionWatcherData] and [ActivityWatcherData].
 * These are known names for files handled by this class:
 * ExcelBinOutput/RewardExcelConfigData.json
 * txt/RewardData.txt (with an appropriate parser)
 * @property rewardId id of this object
 * @property hcoin amount of hcoin (primogems) to reward
 * @property scoin amount of scoin (mora) to reward
 * @property playerExp amount of player/adventure rank exp to reward
 * @property rewardItemList list of items to reward
 * @property characterExp amount of character exp to reward
 * @property friendshipExp amount of friendship exp to reward
 * @property resin amount of resin to reward
 * @property outputSourceType TODO what is this
 * @property dailyLimit limit of how much the player can get per day
 * @property totalLimit limit of how much the player can get over the lifetime of the account
 * @property activityLimit limit of how much the player can get during a specific event schedule
 */
@Serializable
@DataFile("ExcelBinOutput/RewardExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/RewardData.txt", FileType.TSV, FolderType.EXCEL)
data class RewardData(
    val rewardId: Int,
    val hcoin: Int = UnsetInt,
    val scoin: Int = UnsetInt,
    val playerExp: Int = UnsetInt,
    val rewardItemList: List<GainItem>,
    // custom
    val characterExp: Int = UnsetInt,
    val friendshipExp: Int = UnsetInt,
    val resin: Int = UnsetInt,
    val outputSourceType: Int = UnsetInt, //TODO what is this
    val dailyLimit: Int = UnsetInt,
    val totalLimit: Int = UnsetInt,
    val activityLimit: Int = UnsetInt,
) : IntKey {
    override fun getIntKey() = rewardId
}
