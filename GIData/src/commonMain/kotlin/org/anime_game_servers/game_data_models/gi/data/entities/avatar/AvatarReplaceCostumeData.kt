package org.anime_game_servers.game_data_models.gi.data.entities.avatar

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * This contains a list of avatar replace costumes, that people should receive automatically.
 * These are known names for files handled by this class:
 * ExcelBinOutput/AvatarReplaceCostumeExcelConfigData.json
 * txt/AvatarReplaceCostumeData.txt
 * @property replaceCostumeId The [AvatarCostumeData.skinId] of the skin that the user should get
 * @property avatarId The [AvatarData.id] of the avatar this costume is from
 */
@DataFile("ExcelBinOutput/AvatarReplaceCostumeExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/AvatarReplaceCostumeData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
@OptIn(ExperimentalSerializationApi::class)
data class AvatarReplaceCostumeData(
    @JsonNames("costumeId")
    val replaceCostumeId: Int,
    @JsonNames("id")
    val avatarId: Int,
    ): IntKey {
    override fun getIntKey() = replaceCostumeId
}
