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
 * ExcelBinOutput/MaterialExcelConfigData.json
 * txt/MaterialData.txt (with an appropriate parser)
 */
@DataFile("ExcelBinOutput/MaterialExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/MaterialData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class MaterialData(
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

    @Serializable(with = MaterialDestroyTypeContainerSerializer::class)
    override val destroyRule: EnumWrapper<MaterialDestroyType>? = null,
    override val destroyReturnMaterial: List<Int>? = null,
    override val destroyReturnMaterialCount: List<Int>? = null,

    @Serializable(with = MaterialTypeContainerSerializer::class)
    val materialType: EnumWrapper<MaterialType>? = null,

    val cdTime: Int = UnsetInt,
    val cdGroup: Int = UnsetInt,
    val stackLimit: Int = UnsetInt,
    val maxUseCount: Int = UnsetInt,
    val rankLevel: Int = UnsetInt,
    val setId: Int = UnsetInt,
    val noFirstGetHint: Boolean? = null,
    val isForceGetHint: Boolean? = null,
    val isSplitDrop: Boolean? = null,
    val useOnGain: Boolean? = null,
    val useTarget: ItemUseTarget? = null,
    val itemUse: List<ItemUseConfig>? = null,

    val satiationParams: List<Int>? = null,

    val addPropLevels: List<Int>? = null,
    val baseConvExp: Int = UnsetInt,
    val maxLevel: Int = UnsetInt,
    val initialLockState: Int = UnsetInt,


    // server only
    override val controlType: String? = null,
    override val itemRankLevel: Int = UnsetInt,
    val autoEnterBag: Boolean? = null,

    // client only
    override val icon: String? = null,
    val playGainEffect: Boolean? = null,
    val effectIcon: String? = null,
    val effectName: String? = null,
    val effectGadgetID: Int = UnsetInt,
    val picPath: List<String>? = null,
    val closeBagAfterUsed: Boolean? = null,
    val isHidden: Boolean? = null,


    @Serializable(with = FoodQualityTypeContainerSerializer::class)
    val foodQuality: EnumWrapper<FoodQualityType>? = null,


    //TextMapHash
    override val nameTextMapHash: TextMapHash = UnsetTextMap,
    override val descTextMapHash: TextMapHash = UnsetTextMap,
    val interactionTitleTextMapHash: TextMapHash = UnsetTextMap,
    val effectDescTextMapHash: TextMapHash = UnsetTextMap,
    val specialDescTextMapHash: TextMapHash = UnsetTextMap,
    val typeDescTextMapHash: TextMapHash = UnsetTextMap,
    ) : ItemData, DestroyableItem, Strippable<MaterialData> {


    override fun strip(config: StripConfig): MaterialData =
        context(config) {
            copy(
                itemUse = itemUse?.stripListByEnumWrapperField(
                    ItemUseConfig::useOp,
                    metadata = ItemUseOpMetadata
                ),

                controlType = controlType.stripServerField(),

                icon = icon.stripClientField(),
                effectIcon = effectIcon.stripClientField(),
                effectName = effectName.stripClientField(),
                picPath = picPath.stripClientField(),
                foodQuality = foodQuality.stripClientField(),
            )
        }

    @Serializable
    data class ItemUseConfig(
        @Serializable(with = ItemUseOpContainerSerializer::class)
        val useOp: EnumWrapper<ItemUseOp>? = null,
        val useParam: List<String>? = null,
    )
}
