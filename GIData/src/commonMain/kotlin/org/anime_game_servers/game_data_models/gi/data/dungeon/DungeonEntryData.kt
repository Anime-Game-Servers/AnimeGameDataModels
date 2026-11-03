package org.anime_game_servers.game_data_models.gi.data.dungeon

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.*
import org.anime_game_servers.game_data_models.gi.helpers.stripListByEnumWrapperField
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType
import org.anime_game_servers.game_data_models.loader.enums.EnumWrapper
import org.anime_game_servers.game_data_models.loader.stripping.StripConfig
import org.anime_game_servers.game_data_models.loader.stripping.Strippable

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

    @Serializable(with = DungeonEntryTypeContainerSerializer::class)
    val type: EnumWrapper<DungeonEntryType>? = null,

    @Serializable(with = LogicTypeContainerSerializer::class)
    val condComb: EnumWrapper<LogicType>? = null,
    val satisfiedCond: List<SatisfiedCond>? = null,


    // Client only
    val descriptionCycleRewardList: List<List<Int>>? = null,
    val picPath: String? = null,


    //textMaps
    val descTextMapHash: TextMapHash = UnsetTextMap,
    ) : IntKey, Strippable<DungeonEntryData> {
    override fun getIntKey() = id

    fun getTypeNonNull() = type?.value ?: DUNGEON_ENTRY_TYPE_NONE
    fun getCondCombNonNull() = condComb?.value ?: LOGIC_NONE
    fun getSatisfiedCondNonNull() = satisfiedCond ?: emptyList()

    override fun strip(config: StripConfig): DungeonEntryData = context(config) {
        copy(
            satisfiedCond = satisfiedCond?.stripListByEnumWrapperField(
                SatisfiedCond::type,
                metadata = DungeonEntrySatisfiedConditionTypeMetadata,
            ),
            descriptionCycleRewardList = descriptionCycleRewardList?.filter {
                (!config.minify || it.isNotEmpty())
            }
        )
    }

    @Serializable
    data class SatisfiedCond (
        @Serializable(with = DungeonEntrySatisfiedConditionTypeContainerSerializer::class)
        val type: EnumWrapper<DungeonEntrySatisfiedConditionType>? = null,
        val param1: Int = 0,
        val param2: Int = 0,
    ){
        fun getTypeNonNull() = type?.value ?: DUNGEON_ENTRY_CONDITION_NONE

    }
}
