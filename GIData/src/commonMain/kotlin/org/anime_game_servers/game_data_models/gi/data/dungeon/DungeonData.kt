package org.anime_game_servers.game_data_models.gi.data.dungeon

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.Element
import org.anime_game_servers.game_data_models.gi.data.general.TextMapHash
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.gi.data.general.UnsetTextMap
import org.anime_game_servers.game_data_models.gi.data.quest.GainItem
import org.anime_game_servers.game_data_models.gi.data.rewards.RewardData
import org.anime_game_servers.game_data_models.gi.data.rewards.RewardPreviewData
import org.anime_game_servers.game_data_models.gi.data.city.CityData
import org.anime_game_servers.game_data_models.gi.data.general.ElementContainerSerializer
import org.anime_game_servers.game_data_models.gi.data.general.ElementMetadata
import org.anime_game_servers.game_data_models.gi.helpers.getNonNull
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType
import org.anime_game_servers.game_data_models.loader.enums.EnumWrapper

/**
 * This contains info about dungeons
 * @property id unique id of this dungeon
 * @property type Enum wrapper with the type of dungeon. [DungeonType.DUNGEON_UNKNOWN] if the string is not a known type
 * @property subType Enum Wrapper with the subtype of the dungeon. [DungeonSubType.DUNGEON_SUB_UNKNOWN] if the string is not a known type
 * @property playType Enum wrapper. [DungeonPlayType.DUNGEON_PLAY_TYPE_UNKNOWN] if the string is not a known type // TODO
 * @property involveType Enum Wrapper. [InvolveType.INVOLVE_UNKNOWN] if the string is not a known type // TODO online type?
 * @property serialId TODO
 * @property eventInterval TODO Script timing event interval?
 * @property sceneId id of the scene to use for this dungeon
 * @property showLevel TODO
 * @property avatarLimitType TODO
 * @property limitLevel the minimum level the player must be to enter this dungeon
 * @property levelRevise TODO
 * @property isDynamicLevel also known as dynamic difficulty TODO
 * @property passCond This references the [id] of a [DungeonPassData] that must be met to pass/complete the dungeon
 * @property passRewardId id for an entry in [RewardData] that contains the data awarded on first pass. Not included in the client data
 * @property passRewardPreviewId id for an entry in [RewardPreviewData]. Might or might not be the same as the RewardData content. Client only
 * @property firstPassRewardPreviewID id for an entry in [RewardPreviewData]. Might or might not be the same as the RewardData content. Client only
 * @property passJumpDungeon The next dungeons [id] to jump to after passing this one
 * @property reviveIntervalTime TODO
 * @property reviveMaxCount Number of times a player can revive in this dungeon before its counted as a fail TODO verify
 * @property dayEnterCount TODO
 * @property settleCountdownTime countdown in seconds after the dungeon is completed before the player is kicked out of the dungeon
 * @property failSettleCountdownTime countdown in seconds after the dungeon is failed before the player is kicked out of the dungeon
 * @property quitSettleCountdownTime countdown in seconds after the player quits the dungeon before the player is kicked out of the dungeon
 * @property settleShows list of Enum Wrappers. [SettleShowType.SETTLE_SHOW_UNKNOWN] if the string is not a known type
 * @property interceptReviveAfterSettle TODO
 * @property statueCostId itemid of the item required to claim the drops from the statue
 * @property statueCostCount amount of the item required to claim the drops from the statue
 * @property statueDrop Drop id for the statues drops
 * @property levelConfigMap The Key references the [DungeonLevelEntityData.id], todo value and details
 * @property cityId the [CityData.cityId] this dungeon is assigned to
 * @property stateType Enum Wrapper. [DungeonStateType.DUNGEON_STATE_UNKNOWN] if the string is not a known type // TODO
 * @property enterCostItems currently unused, but should be a list of items required to enter the dungeon
 * @property forbiddenRestart Client only TODO
 * @property dontShowPushTips Client only TODO
 * @property enableQuestGuide Client only TODO
 * @property settleUIType Client only. Enum Wrapper. [SettleUIType.SETTLE_UI_UNKNOWN] if the string is not a known type
 * @property recommendElementTypes Client only. List of the Enum Wrappers. [Element.DEFAULT] if the string is not a known type // TODO
 * @property previewMonsterList Client only TODO
 * @property entryPicPath Client only TODO
 * @property factorPic Client only TODO
 * @property factorIcon Client only TODO
 * @property dungeonEntryRecommendTips Client only TODO
 * @property nameTextMapHash Client only TextMapHash for the name of the dungeon
 * @property displayNameTextMapHash Client only TODO
 * @property descTextMapHash Client only TextMapHash for the description of the dungeon
 * @property gearDescTextMapHash Client only TODO
 */
@OptIn(ExperimentalSerializationApi::class)
@DataFile("ExcelBinOutput/DungeonExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/DungeonData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class DungeonData(
    val id: Int,
    @Serializable(with = DungeonTypeContainerSerializer::class)
    val type: EnumWrapper<DungeonType>? = null,
    @Serializable(with = DungeonSubTypeContainerSerializer::class)
    val subType: EnumWrapper<DungeonSubType>? = null,
    @Serializable(with = DungeonPlayTypeContainerSerializer::class)
    val playType: EnumWrapper<DungeonPlayType>? = null,
    @Serializable(with = InvolveTypeContainerSerializer::class)
    val involveType: EnumWrapper<InvolveType>? = null,

    val serialId: Int = UnsetInt,
    val eventInterval: Int = UnsetInt,
    val sceneId: Int = UnsetInt,
    val showLevel: Int = UnsetInt,
    val avatarLimitType: Int = UnsetInt,
    val limitLevel: Int = UnsetInt,
    val levelRevise: Int = UnsetInt,
    val isDynamicLevel: Boolean? = null,
    val passCond: Int = UnsetInt,
    val passRewardId: Int = UnsetInt, // server only
    val passRewardPreviewId: Int = UnsetInt, //client only
    val firstPassRewardPreviewID: Int = UnsetInt, //client only
    val passJumpDungeon: Int = UnsetInt,
    val reviveIntervalTime: Int = UnsetInt,
    val reviveMaxCount: Int = UnsetInt,
    val dayEnterCount: Int = UnsetInt,
    val settleCountdownTime: Int = UnsetInt,
    val failSettleCountdownTime: Int = UnsetInt,
    val quitSettleCountdownTime: Int = UnsetInt,

    val settleShows: List<
            @Serializable(with = SettleShowTypeContainerSerializer::class)
            EnumWrapper<SettleShowType>
            >? = null,
    val interceptReviveAfterSettle: Boolean? = null,
    @JsonNames("statueCostID")
    val statueCostId: Int = UnsetInt,
    val statueCostCount: Int = UnsetInt,
    val statueDrop: Int = UnsetInt,
    val levelConfigMap: Map<String, Int>? = null,
    val cityId: Int = UnsetInt,
    @Serializable(with = DungeonStateTypeContainerSerializer::class)
    val stateType: EnumWrapper<DungeonStateType>? = null,
    val enterCostItems: List<GainItem> ? = null,

    // Client only
    val forbiddenRestart: Boolean? = null,
    val dontShowPushTips: Boolean? = null,
    val enableQuestGuide: Boolean? = null,
    @Serializable(with = SettleUITypeContainerSerializer::class)
    val settleUIType: EnumWrapper<SettleUIType>? = null,

    val recommendElementTypes: List<
            @Serializable(with = ElementContainerSerializer::class)
            EnumWrapper<Element>
            >? = null,
    val previewMonsterList: List<Int>? = null,
    val entryPicPath: String? = null,
    val factorPic: String? = null,
    val factorIcon: String? = null,
    val dungeonEntryRecommendTips: List<String>? = null,

    //textMaps
    val nameTextMapHash: TextMapHash = UnsetTextMap,
    val displayNameTextMapHash: TextMapHash = UnsetTextMap,
    val descTextMapHash: TextMapHash = UnsetTextMap,
    val gearDescTextMapHash: TextMapHash = UnsetTextMap,
) : IntKey {
    override fun getIntKey() = id

    fun getDungeonTypeNonNull() = type?.value ?: DUNGEON_NONE
    fun getDungeonSubTypeNonNull() = subType?.value ?: DUNGEON_SUB_NONE
    fun getPlayTypeNonNull() = playType?.value ?: DUNGEON_PLAY_TYPE_NONE
    fun getInvolveTypeNonNull() = involveType?.value ?: INVOLVE_NONE
    fun isDynamicLevelNonNull() = isDynamicLevel.getNonNull()
    fun getSettleShowsNonNull() = settleShows.getNonNull()
    fun getInterceptReviveAfterSettleNonNull() = interceptReviveAfterSettle.getNonNull()
    fun getLevelConfigMapNonNull() = levelConfigMap.getNonNull()
    fun getStateTypeNonNull() = stateType?.value ?: DUNGEON_STATE_NONE
}
