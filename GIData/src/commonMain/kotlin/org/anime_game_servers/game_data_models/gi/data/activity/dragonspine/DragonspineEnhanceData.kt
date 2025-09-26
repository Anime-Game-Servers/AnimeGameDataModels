package org.anime_game_servers.game_data_models.gi.data.activity.dragonspine

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
 * ExcelBinOutput/DragonSpineEnhanceExcelConfigData.json
 * txt/DragonSpineEnhanceData.txt (with an appropriate parser)
 * @property id TODO
 * @property activityAbilityGroupId id if the ability group to activate from [org.anime_game_servers.game_data_models.gi.data.activity.ActivityAbilityGroupData]
 * @property process TODO
 * @property descTextMapHash TODO
 */
@DataFile("ExcelBinOutput/DragonSpineEnhanceExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/DragonSpineEnhanceData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class DragonspineEnhanceData(
    val id: Int,
    val activityAbilityGroupId: Int = UnsetInt,
    val process: Int = UnsetInt,

    // TextMapHashes
    val descTextMapHash: TextMapHash = UnsetTextMap,
) : IntKey {
    override fun getIntKey() = id
}
