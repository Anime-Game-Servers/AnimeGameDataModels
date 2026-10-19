package org.anime_game_servers.game_data_models.gi.data.dungeon

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
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
import org.anime_game_servers.game_data_models.gi.helpers.getNonNull
import org.anime_game_servers.game_data_models.gi.helpers.nullableEnumValueOfOrDefault
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * This contains info about dungeons
 * @property id unique id of this dungeon
 * @property typeString type of dungeon
 * @property type enum representation of typeString. [DungeonType.DUNGEON_UNKNOWN] if the string is not a known type
 * @property subTypeString subtype of dungeon
 * @property subType enum representation of subTypeString. [DungeonSubType.DUNGEON_SUB_UNKNOWN] if the string is not a known type
 * @property playTypeString TODO
 * @property playType enum representation of playTypeString. [DungeonPlayType.DUNGEON_PLAY_TYPE_UNKNOWN] if the string is not a known type
 * @property involveTypeString TODO Online Type?
 * @property involveType enum representation of involveTypeString. [InvolveType.INVOLVE_UNKNOWN] if the string is not a known type
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
 * @property settleShowStrings TODO
 * @property settleShows list of the enum representations of settleShowStrings. [SettleShowType.SETTLE_SHOW_UNKNOWN] if the string is not a known type
 * @property interceptReviveAfterSettle TODO
 * @property statueCostId itemid of the item required to claim the drops from the statue
 * @property statueCostCount amount of the item required to claim the drops from the statue
 * @property statueDrop Drop id for the statues drops
 * @property levelConfigMap The Key references the [DungeonLevelEntityData.id], todo value and details
 * @property cityId the [CityData.cityId] this dungeon is assigned to
 * @property stateTypeString TODO
 * @property stateType enum representation of stateTypeString. [DungeonStateType.DUNGEON_STATE_UNKNOWN] if the string is not a known type
 * @property enterCostItems currently unused, but should be a list of items required to enter the dungeon
 * @property forbiddenRestart Client only TODO
 * @property dontShowPushTips Client only TODO
 * @property enableQuestGuide Client only TODO
 * @property settleUITypeString Client only TODO
 * @property settleUIType enum representation of settleUITypeString. [SettleUIType.SETTLE_UI_UNKNOWN] if the string is not a known type
 * @property recommendElementTypeStrings Client only TODO
 * @property recommendElementTypes list of the enum representations of recommendElementTypeStrings. [Element.DEFAULT] if the string is not a known type
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
    @SerialName("type")
    val typeString: String? = null,
    @Transient
    val type: DungeonType? = nullableEnumValueOfOrDefault(typeString, DungeonType.DUNGEON_UNKNOWN),
    @SerialName("subType")
    val subTypeString: String? = null,
    @Transient
    val subType: DungeonSubType? = nullableEnumValueOfOrDefault(subTypeString, DungeonSubType.DUNGEON_SUB_UNKNOWN),
    @SerialName("playType")
    val playTypeString: String? = null,
    @Transient
    val playType: DungeonPlayType? = nullableEnumValueOfOrDefault(playTypeString, DungeonPlayType.DUNGEON_PLAY_TYPE_UNKNOWN),
    @SerialName("involveType")
    val involveTypeString: String? = null,
    @Transient
    val involveType: InvolveType? = nullableEnumValueOfOrDefault(involveTypeString, InvolveType.INVOLVE_UNKNOWN),

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
    @SerialName("settleShows")
    val settleShowStrings: List<String>? = null,
    @Transient
    val settleShows: List<SettleShowType>? = settleShowStrings?.mapNotNull { nullableEnumValueOfOrDefault(it, SettleShowType.SETTLE_SHOW_UNKNOWN) },
    val interceptReviveAfterSettle: Boolean? = null,
    @JsonNames("statueCostID")
    val statueCostId: Int = UnsetInt,
    val statueCostCount: Int = UnsetInt,
    val statueDrop: Int = UnsetInt,
    val levelConfigMap: Map<String, Int>? = null,
    val cityId: Int = UnsetInt,
    @SerialName("stateType")
    val stateTypeString: String? = null,
    @Transient
    val stateType: DungeonStateType? = nullableEnumValueOfOrDefault(stateTypeString, DungeonStateType.DUNGEON_STATE_UNKNOWN),
    val enterCostItems: List<GainItem> ? = null,

    // Client only
    val forbiddenRestart: Boolean? = null,
    val dontShowPushTips: Boolean? = null,
    val enableQuestGuide: Boolean? = null,
    val settleUITypeString: String? = null,
    @Transient
    val settleUIType: SettleUIType? = nullableEnumValueOfOrDefault(settleUITypeString, SettleUIType.SETTLE_UI_UNKNOWN),
    @SerialName("recommendElementTypes")
    val recommendElementTypeStrings: List<String>? = null,
    @Transient
    val recommendElementTypes: List<Element>? = recommendElementTypeStrings?.mapNotNull { nullableEnumValueOfOrDefault(it, Element.DEFAULT) },
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

    fun getDungeonTypeNonNull() = type ?: DungeonType.DUNGEON_NONE
    fun getDungeonSubTypeNonNull() = subType ?: DungeonSubType.DUNGEON_SUB_NONE
    fun getPlayerTypeNonNull() = playType ?: DungeonPlayType.DUNGEON_PLAY_TYPE_NONE
    fun getInvolveTypeNonNull() = involveType ?: InvolveType.INVOLVE_NONE
    fun isDynamicLevelNonNull() = isDynamicLevel.getNonNull()
    fun getSettleShowsNonNull() = settleShows.getNonNull()
    fun getInterceptReviveAfterSettleNonNull() = interceptReviveAfterSettle.getNonNull()
    fun getLevelConfigMapNonNull() = levelConfigMap.getNonNull()
    fun getStateTypeNonNull() = stateType ?: DungeonStateType.DUNGEON_STATE_NONE
}
