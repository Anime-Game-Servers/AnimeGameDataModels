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
 * ExcelBinOutput/HomeWorldFurnitureExcelConfigData.json
 * txt/FurnitureExcelData.txt (with an appropriate parser)
 */
@DataFile("ExcelBinOutput/HomeWorldFurnitureExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/FurnitureExcelData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class HomeWorldFurnitureData(
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

    val furnitureGadgetID: List<Int>? = null,
    val furnType: List<Int>? = null,
    val arrangeLimit: Int = UnsetInt,
    val roomSceneID: Int = UnsetInt,
    val comfort: Int = UnsetInt,
    val stackLimit: Int = UnsetInt,
    val cost: Int = UnsetInt,
    val discountCost: Int = UnsetInt,
    val isCombinableLight: Int = UnsetInt,
    val rankLevel: Int = UnsetInt,
    val pushTipsId: Int = UnsetInt,
    val jsonName: String? = null,
    val blockLegoText: Boolean? = null,

    @Serializable(with = FurnitureDeploySurfaceTypeContainerSerializer::class)
    val surfaceType: EnumWrapper<FurnitureDeploySurfaceType>? = null,

    val isSpecialFurniture: Int = UnsetInt, // client only
    @Serializable(with = SpecialFurnitureTypeContainerSerializer::class)
    val specialFurnitureType: EnumWrapper<SpecialFurnitureType>? = null,

    @Serializable(with = GroupRecordTypeContainerSerializer::class)
    val groupRecordType: EnumWrapper<GroupRecordType>? = null,


    // server only
    override val controlType: String? = null,
    override val itemRankLevel: Int = UnsetInt,

    // client only
    override val icon: String? = null,
    val height: Float = UnsetFloat,
    val gridStyle: Int = UnsetInt,
    val canFloat: Int = UnsetInt,
    val isUnique: Int = UnsetInt,
    val itemIcon: String? = null,
    val effectIcon: String? = null,
    val clampDistance: Float = UnsetFloat,
    val editorClampDistance: Float = UnsetFloat,
    val deployGlitchIndex: Int = UnsetInt,

    val floatIndicatorId: Int = UnsetInt, // Added in 3.3 or 3.4. OJGLBFDOPAF/MHBBPCHKCFP in 3.4. name from dims resources
    val sourceTextList: List<Int>? = null, //  Added in 3.3 or 3.4. OKDPOMPFNLE/IMMMCMKDBPK in 3.4. name from dims resources

    //TextMapHash
    override val nameTextMapHash: TextMapHash = UnsetTextMap,
    override val descTextMapHash: TextMapHash = UnsetTextMap,
    ) : ItemData, Strippable<HomeWorldFurnitureData> {

    override fun strip(config: StripConfig): HomeWorldFurnitureData = context(config){
        copy(
            controlType = controlType.stripServerField(),
            icon = icon.stripClientField(),
            itemIcon = itemIcon.stripClientField(),
            effectIcon = effectIcon.stripClientField(),
            sourceTextList = sourceTextList.stripClientField()
        )
    }
    }
