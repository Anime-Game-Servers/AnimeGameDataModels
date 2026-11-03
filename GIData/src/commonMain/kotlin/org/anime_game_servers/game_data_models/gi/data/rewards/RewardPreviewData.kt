@file:OptIn(ExperimentalSerializationApi::class)

package org.anime_game_servers.game_data_models.gi.data.rewards

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.core.base.interfaces.StringKey
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType
import org.anime_game_servers.game_data_models.loader.stripping.StripConfig
import org.anime_game_servers.game_data_models.loader.stripping.Strippable

/**
 * TODO document
 * This file is only part of the client data and not used on the server side.
 * These are known names for files handled by this class:
 * ExcelBinOutput/RewardPreviewExcelConfigData.json
 */
@DataFile("ExcelBinOutput/RewardPreviewExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@Serializable
data class RewardPreviewData(
    @JsonNames("Desc")
    val desc:String? = null,
    val id: Int = 0,
    val previewItems: List<RewardPreviewItem>? = null,
): StringKey, IntKey, Strippable<RewardPreviewData> {
    override fun getStringKey() = id.toString()+desc
    override fun getIntKey() = id

    fun getPreviewItemsNonNull() = previewItems ?: emptyList()

    override fun strip(config: StripConfig): RewardPreviewData {
        return copy(
            previewItems = previewItems?.filter { item ->
                (!config.minify || item.id != UnsetInt)
            }
        )
    }


}
