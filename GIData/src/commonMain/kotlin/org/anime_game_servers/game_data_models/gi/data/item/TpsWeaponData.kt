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
 * [Custom name] TODO
 * 
 * These are known names for files handled by this class:
 * ExcelBinOutput/TpsWeaponExcelConfigData.json
 * txt/TpsWeaponData.txt (with an appropriate parser)
 * @param tpsWeaponType [custom name]
 * @param tpsWeaponElements [custom name]
 */
@DataFile("ExcelBinOutput/TpsWeaponExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/TpsWeaponData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class TpsWeaponData(
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
    val skillId: Int = UnsetInt,

    @Serializable(with = ElementContainerSerializer::class)
    val tpsWeaponType: EnumWrapper<TpsWeaponType>? = null,

    val tpsWeaponElements: List<
            @Serializable(with = ElementContainerSerializer::class)
            EnumWrapper<Element>
            >? = null,

    // todo unknown field DJEFBHIOPOM in 7.1, boolean, shared with MusicGameThemeData
    // todo unknown field MNOEGOHMEMG in 7.1, long likely a TextHash, unique
    // todo unknown field PIHHHIMPCAM in 7.1, int, shared with TpsWeaponAccessoryData
    // todo unknown field BMPEDGJECGI in 7.1, String globalValueKey?, unique
    // todo unknown field PHCGJCFENJP in 7.1, int array, shared with TpsWeaponAccessoryData
    // todo unknown field MMAHLBBNDCH in 7.1, int array, shared with TpsAmmunitionData
    // todo unknown field ANPKGOFBHLI in 7.1, int, unique
    // todo unknown field FNFHHMPAEJL in 7.1, string, unique
    // todo unknown field NNJGEAPMJFL in 7.1, int, unique
    // todo unknown field KHHMMJKEIOF in 7.1, float, shared with

    // server only
    override val controlType: String? = null,
    override val itemRankLevel: Int = UnsetInt,

    // client only
    override val icon: String? = null,

    //TextMapHash
    override val nameTextMapHash: TextMapHash = UnsetTextMap,
    override val descTextMapHash: TextMapHash = UnsetTextMap,
    ) : ItemData, Strippable<TpsWeaponData> {

    override fun strip(config: StripConfig): TpsWeaponData = context(config) {
        copy(
            controlType = controlType.stripServerField(),
            icon = icon.stripClientField(),
        )
    }
}
