package org.anime_game_servers.game_data_models.gi.data.entities.avatar

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.entities.FightPropType
import org.anime_game_servers.game_data_models.gi.data.entities.FightPropTypeContainerSerializer
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType
import org.anime_game_servers.game_data_models.loader.enums.EnumWrapper

/**
 * TODO document
 * These are known names for files handled by this class:
 * ExcelBinOutput/AvatarExtraPropExcelConfigData.json
 * txt/AvatarExtraPropertyData.txt
 */
@DataFile("ExcelBinOutput/AvatarExtraPropExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/AvatarExtraPropertyData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
@OptIn(ExperimentalSerializationApi::class)
data class AvatarExtraPropData(
    @JsonNames("ID")
    val id: Int,
    val maxCount: Int = UnsetInt,
    val addProps: List<AddProperty>? = null,

    ): IntKey {
    override fun getIntKey() = id

    @Serializable
    data class AddProperty(
        @Serializable(with = FightPropTypeContainerSerializer::class)
        val propType: EnumWrapper<FightPropType>? = null,
        val propValue: String
    )
}
