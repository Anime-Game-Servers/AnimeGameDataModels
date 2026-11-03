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
 * ExcelBinOutput/ReliquaryExcelConfigData.json
 * txt/ReliquaryData.txt (with an appropriate parser)
 */
@DataFile("ExcelBinOutput/ReliquaryExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/ReliquaryData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class ReliquaryData(
    override val id: Int,
    @Serializable(with = ItemTypeContainerSerializer::class)
    override val itemType: EnumWrapper<ItemType>? = null,
    override val weight: Int = UnsetInt,
    override val rank: Int = UnsetInt,
    override val gadgetId: Int = UnsetInt,
    override val useLevel: Int = UnsetInt,
    @JsonNames("dropable")
    override val droppable: Boolean? = null,
    override val globalItemLimit: Int = UnsetInt,

    @Serializable(with = MaterialDestroyTypeContainerSerializer::class)
    override val destroyRule: EnumWrapper<MaterialDestroyType>? = null,
    override val destroyReturnMaterial: List<Int>? = null,
    override val destroyReturnMaterialCount: List<Int>? = null,

    @Serializable(with = EquipTypeContainerSerializer::class)
    val equipType: EnumWrapper<EquipType>? = null,
    val rankLevel: Int = UnsetInt,
    val mainPropDepotId: Int = UnsetInt,
    val appendPropDepotId: Int = UnsetInt,
    val appendPropNum: Int = UnsetInt,
    val setId: Int = UnsetInt,
    val addPropLevels: List<Int>? = null,
    val baseConvExp: Int = UnsetInt,
    val maxLevel: Int = UnsetInt,
    val initialLockState: Int = UnsetInt,

    // server only
    override val controlType: String? = null,
    override val itemRankLevel: Int = UnsetInt,

    // client only
    override val icon: String? = null,

    val showPic: String? = null,
    val storyId: Int = UnsetInt,

    //TextMapHash
    override val nameTextMapHash: TextMapHash = UnsetTextMap,
    override val descTextMapHash: TextMapHash = UnsetTextMap,
) : ItemData, DestroyableItem, Strippable<ReliquaryData> {
    override fun strip(config: StripConfig): ReliquaryData = context(config) {
        copy(
            controlType = controlType.stripServerField(),
            icon = icon.stripClientField(),
            showPic = showPic.stripClientField(),
        )
    }
}
