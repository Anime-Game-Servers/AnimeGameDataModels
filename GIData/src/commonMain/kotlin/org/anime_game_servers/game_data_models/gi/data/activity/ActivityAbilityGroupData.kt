package org.anime_game_servers.game_data_models.gi.data.activity

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.TextMapHash
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.gi.data.general.UnsetTextMap
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * TODO: Documentation
 * These are known names for files handled by this class:
 * ExcelBinOutput/ActivityAbilityGroupExcelConfigData.json
 * txt/ActivityAbilityGroupData.txt (with an appropriate parser)
 * @property index TODO
 * @property activityId TODO
 * @property avatarId TODO
 * @property weaponId TODO
 * @property nameTextMapHash TODO
 */
@DataFile("ExcelBinOutput/ActivityAbilityGroupExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/ActivityAbilityGroupData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class ActivityAbilityGroupData(
    val index: Int,
    val activityId: Int = UnsetInt,
    val avatarId: Int = UnsetInt,
    val weaponId: Int = UnsetInt,

    // TextMapHashes
    val nameTextMapHash: TextMapHash = UnsetTextMap,
) : IntKey {
    override fun getIntKey() = index
}
