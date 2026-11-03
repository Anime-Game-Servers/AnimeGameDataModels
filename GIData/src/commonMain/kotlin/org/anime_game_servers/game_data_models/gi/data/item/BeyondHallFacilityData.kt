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
 * ExcelBinOutput/BeyondHallFacilityExcelConfigData.json
 * txt/BeyondHallFacilityData.txt (with an appropriate parser)
 * @param tpsWeaponType [custom name]
 * @param tpsWeaponElements [custom name]
 */
@DataFile("ExcelBinOutput/BeyondHallFacilityExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/BeyondHallFacilityData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class BeyondHallFacilityData(
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
    val discountCost: Int = UnsetInt,
    val arrangeLimit: Int = UnsetInt,
    val cost: Int = UnsetInt,

    @Serializable(with = TpsWeaponTypeContainerSerializer::class)
    val tpsWeaponType: EnumWrapper<TpsWeaponType>? = null,

    val tpsWeaponElements: List<
            @Serializable(with = ElementContainerSerializer::class)
            EnumWrapper<Element>
            >? = null,


    // todo unknown field BKMBOBBHFIM in 7.1, enum [NDBFIDFOACC], unique
    // todo unknown field IAPODIMHILF in 7.1, int, shared with BeyondHallFacilityType, probably the typeId
    // todo unknown field ICKENHBIAGI in 7.1, enum [AIDFLMBJIEB], unique
    // todo unknown field FIDKMNHAIPC in 7.1, enum [GEGCIGJAOFF], unique
    // todo unknown field GCABMKJNPCK in 7.1, int, unique
    // todo unknown field GNAIAOPJECA in 7.1, boolean, unique
    // todo unknown field LIIIBGGKKKH in 7.1, int probably gadget id, unique
    // todo unknown field KMLBDAEHOPD in 7.1, string, unique

    // server only
    override val controlType: String? = null,
    override val itemRankLevel: Int = UnsetInt,

    // client only
    override val icon: String? = null,

    //TextMapHash
    override val nameTextMapHash: TextMapHash = UnsetTextMap,
    override val descTextMapHash: TextMapHash = UnsetTextMap,
    ) : ItemData, Strippable<BeyondHallFacilityData> {

    override fun strip(config: StripConfig): BeyondHallFacilityData = context(config) {
        copy(
            controlType = controlType.stripServerField(),
            icon = icon.stripClientField(),
        )
    }
}
