@file:OptIn(ExperimentalSerializationApi::class)

package org.anime_game_servers.game_data_models.gi.data.dungeon

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.*
import org.anime_game_servers.game_data_models.gi.helpers.nullableEnumValueOfOrDefault
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * TODO
 */
@DataFile("ExcelBinOutput/DungeonEntryExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/DungeonEntryData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class DungeonEntryData(
    val id: Int,
    val sceneId: Int = UnsetInt,
    val dungeonEntryId: Int = UnsetInt,
    val rewardDataId: Int = UnsetInt,
    val systemOpenUiId: Int = UnsetInt,
    val isShowInAdvHandbook: Boolean? = null,
    val isDailyRefresh: Boolean? = null,
    val isDefaultOpen: Boolean? = null,
    val cooldownTipsDungeonId: List<Int>? = null,

    @SerialName("type")
    val typeString: String? = null,
    @Transient
    val type: DungeonEntryType? = nullableEnumValueOfOrDefault(typeString, DUNGEON_ENTRY_TYPE_UNKNOWN),

    @SerialName("condComb")
    val condCombString: String? = null,
    @Transient
    val condComb: LogicType? = nullableEnumValueOfOrDefault(condCombString, LOGIC_UNKNOWN),
    val satisfiedCond: List<SatisfiedCond>,


    // Client only
    val descriptionCycleRewardList: List<List<Int>>? = null,
    val picPath: String? = null,


    //textMaps
    val descTextMapHash: TextMapHash = UnsetTextMap,
    ) : IntKey {
    override fun getIntKey() = id


    @Serializable
    data class SatisfiedCond (
        @SerialName("type")
        val typeString: String? = null,
        @Transient
        val type: DungeonEntrySatisfiedConditionType? = nullableEnumValueOfOrDefault(typeString, DUNGEON_ENTRY_CONDITION_UNKNOWN),
        val param1: Int = 0,
        val param2: Int = 0,
    )
}
