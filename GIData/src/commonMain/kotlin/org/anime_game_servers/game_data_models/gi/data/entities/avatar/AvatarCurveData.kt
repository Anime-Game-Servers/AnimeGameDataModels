package org.anime_game_servers.game_data_models.gi.data.entities.avatar

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.ArithType
import org.anime_game_servers.game_data_models.gi.data.general.ArithTypeContainerSerializer
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType
import org.anime_game_servers.game_data_models.loader.enums.EnumWrapper

/**
 * This contains information about the stats growth with each level for characters/avatars.
 * These are known names for files handled by this class:
 * ExcelBinOutput/AvatarCurveExcelConfigData.json
 * txt/AvatarExtraPropertyData.txt
 * @property level The level of the character to apply this growth curve to
 * @property curveInfos The growth curve information for the character at this level
 */
@DataFile("ExcelBinOutput/AvatarCurveExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/AvatarCirveData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class AvatarCurveData(
    val level: Int,
    val curveInfos: List<GrowCurveInfo>? = null,
): IntKey {
    override fun getIntKey() = level

    fun getCurveInfosNonNull() = curveInfos ?: emptyList()

    /**
     * Contains information about the growth curve of a character at a certain level
     * @property type The enum wrapper for the type of curve/stat to change. [GrowthCurveType.GROW_CURVE_UNKNOWN] if set to something not in the enum
     * @property arith The enum wrapper with type of arithmetic to use for changing this stat. [ArithType.ARITH_UNKNOWN] if set to something not in the enum
     * @property value The value of the growth curve
     */
    @Serializable
    data class GrowCurveInfo(
        @Serializable(with = GrowthCurveTypeContainerSerializer::class)
        val type: EnumWrapper<GrowthCurveType>? = null,
        @Serializable(with = ArithTypeContainerSerializer::class)
        val arith: EnumWrapper<ArithType>? = null,
        val value: Float
    ){
        fun getTypeNonNull(): GrowthCurveType {
            return type?.value ?: GROW_CURVE_NONE
        }

        fun getArithNonNull(): ArithType {
            return arith?.value ?: ARITH_NONE
        }
    }
}
