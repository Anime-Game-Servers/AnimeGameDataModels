package org.anime_game_servers.game_data_models.gi.data.activity

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.LogicType
import org.anime_game_servers.game_data_models.gi.data.general.LogicTypeContainerSerializer
import org.anime_game_servers.game_data_models.gi.data.general.LogicTypeMetadata
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.gi.helpers.getNonNull
import org.anime_game_servers.game_data_models.gi.helpers.getValueNonNull
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType
import org.anime_game_servers.game_data_models.loader.enums.EnumWrapper

/**
 * This contains information about conditions during activities.
 * Changes to these conditions can trigger external events by systems listening to them,and also ActivityActions that
 * are triggered directly internally
 * These are known names for files handled by this class:
 * Patches/Activity/NewActivityCondData.json
 * ExcelBinOutput/NewActivityCondExcelConfigData.json
 * txt/NewActivityCondData.txt (with an appropriate parser)
 * @property id The ID of the condition
 * @property condComb The type of logic to use when combining the conditions
 * @property cond The list of conditions that must be met for this condition to be valid/not be met to be invalid
 * @property onValidExec The list of ActivityActions to execute when the condition is valid
 * @property onInvalidExec The list of ActivityActions to execute when the condition is invalid
 */
@DataFile("ExcelBinOutput/NewActivityCondExcelConfigData.json", FileType.JSON,FolderType.EXCEL)
@DataFile("txt/NewActivityCondData.txt", FileType.TSV, FolderType.EXCEL)
@DataFile("Patches/Activity/NewActivityCondData.json", FileType.JSON, FolderType.PATCH)
@DataFile("Generated/Activity/NewActivityCondData.json", FileType.JSON, FolderType.GENERATED)
@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class ActivityCondData(
    @JsonNames("condId")
    val id: Int,
    @Serializable(with = LogicTypeContainerSerializer::class)
    val condComb: EnumWrapper<LogicType>? = null,
    val cond: List<ActivityConfigCondition>? = null,

    val onValidExec: List<ActivityConfigExec>? = null,
    val onInvalidExec: List<ActivityConfigExec>? = null,
) : IntKey {
    override fun getIntKey() = id

    fun getCondCombNonNull() = condComb.getValueNonNull(LogicTypeMetadata)
    fun getCondNonNull() = cond.getNonNull()
    fun getOnValidExecNonNull() = onValidExec.getNonNull()
    fun getOnInvalidExecNonNull() = onInvalidExec.getNonNull()

    /**
     * Defines one condition for an ActivityCondData
     * The params usage depends on the type
     * @param type TODO
     * @param param was originally an Int Array, now its using Strings TODO
     */
    @Serializable
    data class ActivityConfigCondition(
        @Serializable(with = ActivityConditionContainerSerializer::class)
        val type: EnumWrapper<ActivityCondition>? = null,
        val param: List<String>? = null,
    ) {
        fun getTypeNonNull() = type?.getValueNonNull(ActivityConditionMetadata)
        fun getParamNonNull() = param.getNonNull()
        // at least [NEW_ACTIVITY_COND_FINISH_ACTIVITY_PLAY_LEVEL] has actually strings, so only use it
        // with known types that have only int params
        fun getIntParamsNonNull() = param.getNonNull().map { try {it.toInt()} catch (e: NumberFormatException) {
            UnsetInt
        } }
    }

    /**
     * Defines an action to be executed when a condition state changes
     * @param param Contains the parameters for the action. The specific meaning of them depends on the type, for info check the type documentation in [ActivityAction]
     */
    @Serializable
    data class ActivityConfigExec(
        @Serializable(with = ActivityActionContainerSerializer::class)
        val type: EnumWrapper<ActivityAction>? = null,
        val param: List<Int>? = null,
    ){
        fun getTypeNonNull() = type?.getValueNonNull(ActivityActionMetadata)
        fun getParamNonNull() = param.getNonNull()
    }
}
