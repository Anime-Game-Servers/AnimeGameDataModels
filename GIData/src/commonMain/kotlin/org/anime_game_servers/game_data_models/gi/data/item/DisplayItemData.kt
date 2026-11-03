@file:OptIn(ExperimentalSerializationApi::class)

package org.anime_game_servers.game_data_models.gi.data.item

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.game_data_models.gi.data.general.*
import org.anime_game_servers.game_data_models.gi.helpers.stripClientField
import org.anime_game_servers.game_data_models.gi.helpers.stripServerField
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType
import org.anime_game_servers.game_data_models.loader.enums.EnumWrapper
import org.anime_game_servers.game_data_models.loader.stripping.StripConfig
import org.anime_game_servers.game_data_models.loader.stripping.Strippable

/**
 * TODO
 * 
 * These are known names for files handled by this class:
 * ExcelBinOutput/DisplayItemExcelConfigData.json
 * txt/DisplayItemData.txt (with an appropriate parser)
 */
@DataFile("ExcelBinOutput/DisplayItemExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/DisplayItemData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class DisplayItemData(
    override val id:Int,
    @Serializable(with = ItemTypeContainerSerializer::class)
    override val itemType: EnumWrapper<ItemType>? = null,
    override val weight: Int = UnsetInt,
    override val rank: Int = UnsetInt,
    override val gadgetId: Int = UnsetInt,
    override val useLevel: Int = UnsetInt,
    @JsonNames("dropable")
    override val droppable: Boolean? = null,
    override val globalItemLimit: Int = UnsetInt,

    val rankLevel: Int = UnsetInt,
    val param: Int = UnsetInt,

    @Serializable(with = ItemTypeContainerSerializer::class)
    val displayType: EnumWrapper<DisplayItemType>? = null,

    // server only
    override val controlType: String? = null,
    override val itemRankLevel: Int = UnsetInt,

    // client only
    override val icon: String? = null,

    //TextMapHash
    override val nameTextMapHash: TextMapHash = UnsetTextMap,
    override val descTextMapHash: TextMapHash = UnsetTextMap,
    ) : ItemData, Strippable<DisplayItemData> {
    override fun strip(config: StripConfig): DisplayItemData  = context(config){
        copy(
            controlType = controlType.stripServerField(),
            icon = icon.stripClientField(),
        )
    }
}
