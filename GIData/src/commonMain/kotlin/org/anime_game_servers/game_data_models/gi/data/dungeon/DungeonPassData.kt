package org.anime_game_servers.game_data_models.gi.data.dungeon

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.LogicType
import org.anime_game_servers.game_data_models.gi.data.general.LogicTypeContainerSerializer
import org.anime_game_servers.game_data_models.gi.helpers.stripListByEnumWrapperField
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType
import org.anime_game_servers.game_data_models.loader.stripping.StripConfig
import org.anime_game_servers.game_data_models.loader.stripping.Strippable
import org.anime_game_servers.game_data_models.loader.enums.EnumWrapper

/**
 * This defines different possible conditions for passing/completing a dungeon. They are referenced by [DungeonData.passCond] via ID.
 * These are known names for files handled by this class:
 * ExcelBinOutput/DungeonPassExcelConfigData.json
 * txt/DungeonPassData.txt (with an appropriate parser)
 * @property id The ID pass info for the dungeon
 * @property logicType The wrapper with the enum and string representation of the logic type from logicTypeString. [LogicType.LOGIC_UNKNOWN] if the string is not a known type
 * @property conds The list of conditions that must be met for the dungeon to be passed
 */
@DataFile("ExcelBinOutput/DungeonPassExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/DungeonPassData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class DungeonPassData(
    val id: Int,
    @Serializable(with = LogicTypeContainerSerializer::class)
    val logicType: EnumWrapper<LogicType>? = null,
    val conds: List<DungeonPassCondition>? = null,
) : IntKey, Strippable<DungeonPassData> {
    override fun getIntKey() = id

    fun getLogicTypeNonNull() = logicType?.value ?: LogicType.LOGIC_NONE

    override fun strip(config: StripConfig): DungeonPassData = context(config) {
        copy(
            conds = conds?.stripListByEnumWrapperField(
                DungeonPassCondition::condType,
                metadata = DungeonPassConditionTypeMetadata
            )
        )
    }

    /**
     * Defines one condition for an DungeonPassData
     * The params usage depends on the type
     * @property condType The wrapper with the enum and string representation of the condition. [DungeonPassConditionType.DUNGEON_COND_UNKNOWN] if the string is not a known type
     * @property param The parameters for the condition
     */
    @Serializable
    data class DungeonPassCondition(
        @Serializable(with = DungeonPassConditionTypeContainerSerializer::class)
        val condType: EnumWrapper<DungeonPassConditionType>? = null,
        val param: List<Int>? = null,
    ) {
        fun getCondTypeNonNull() = condType?.value ?: DUNGEON_COND_NONE
    }

}
