@file:OptIn(ExperimentalSerializationApi::class)

package org.anime_game_servers.game_data_models.gi.data.item

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.game_data_models.gi.data.general.*
import org.anime_game_servers.game_data_models.gi.helpers.stripClientField
import org.anime_game_servers.game_data_models.gi.helpers.stripListByEnumWrapperField
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
 * ExcelBinOutput/BydMaterialExcelConfigData.json
 * txt/BydMaterialData.txt (with an appropriate parser)
 * @param materialType [custom name]
 */
@DataFile("ExcelBinOutput/BydMaterialExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/BydMaterialData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class BydMaterialData(
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
    val stackLimit: Int = UnsetInt,
    val isForceGetHint: Boolean? = null,
    val useOnGain: Boolean? = null,
    val itemUse: List<BydMaterialUseConfig>? = null,

    @Serializable(with = BeyondMaterialTypeContainerSerializer::class)
    val materialType: EnumWrapper<BeyondMaterialType>? = null,

    // todo unknown field EKBBNAHKGCB in 7.1, potentially a TextMapHash
    // todo unknown field CPJIJMDHGML in 7.1, probably int/uint
    // todo unknown field BLFCNNGIOEM in 7.1, string with path for costume icon

    // server only
    override val controlType: String? = null,
    override val itemRankLevel: Int = UnsetInt,

    // client only
    override val icon: String? = null,

    //TextMapHash
    override val nameTextMapHash: TextMapHash = UnsetTextMap,
    override val descTextMapHash: TextMapHash = UnsetTextMap,
    ) : ItemData, Strippable<BydMaterialData> {

    override fun strip(config: StripConfig): BydMaterialData = context(config) {
        copy(
            itemUse = itemUse?.stripListByEnumWrapperField(
                accessor = BydMaterialUseConfig::useOp,
                metadata = BydMaterialUseOpMetadata
            ),

            controlType = controlType.stripServerField(),
            icon = icon.stripClientField(),
        )
    }

    @Serializable
    data class BydMaterialUseConfig(
        @Serializable(with = BydMaterialUseOpContainerSerializer::class)
        val useOp: EnumWrapper<BydMaterialUseOp>? = null,
        val useParam: List<String>? = null,
    )
}
