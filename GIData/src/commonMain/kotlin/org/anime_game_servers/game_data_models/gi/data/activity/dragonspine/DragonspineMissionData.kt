package org.anime_game_servers.game_data_models.gi.data.activity.dragonspine

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.gi.helpers.nullableEnumValueOfOrDefault
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * TODO: Documentation
 * These are known names for files handled by this class:
 * ExcelBinOutput/DragonSpineMissionExcelConfigData.json
 * txt/DragonSpineMissionData.txt (with an appropriate parser)
 * @property id TODO
 * @property chapterId TODO
 * @property watcherId TODO
 * @property finishExec TODO
 */
@DataFile("ExcelBinOutput/DragonSpineMissionExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/DragonSpineMissionData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class DragonspineMissionData(
    val id: Int,
    val chapterId: Int = UnsetInt,
    val watcherId: Int = UnsetInt,
    val finishExec: List<DragonspineFinishExec>? = null,
) : IntKey {
    override fun getIntKey() = id

    @Serializable
    data class DragonspineFinishExec(
        @SerialName("type")
        val typeString: String? = null,
        @Transient
        val type: DragonspineMissionExecType? = nullableEnumValueOfOrDefault(typeString, DRAGON_SPINE_EXEC_TYPE_UNKNOWN),
        val param: List<String>? = null,
    )
}
