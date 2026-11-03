@file:OptIn(ExperimentalSerializationApi::class)

package org.anime_game_servers.game_data_models.gi.data.item

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.game_data_models.gi.data.entities.FightPropType
import org.anime_game_servers.game_data_models.gi.data.entities.FightPropTypeContainerSerializer
import org.anime_game_servers.game_data_models.gi.data.entities.avatar.GrowthCurveType
import org.anime_game_servers.game_data_models.gi.data.entities.avatar.GrowthCurveTypeContainerSerializer
import org.anime_game_servers.game_data_models.gi.data.entities.avatar.WeaponType
import org.anime_game_servers.game_data_models.gi.data.entities.avatar.WeaponTypeContainerSerializer
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
 * ExcelBinOutput/WeaponExcelConfigData.json
 * txt/WeaponData.txt (with an appropriate parser)
 */
@DataFile("ExcelBinOutput/WeaponExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/WeaponData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class WeaponData(
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


    @Serializable(with = WeaponTypeContainerSerializer::class)
    val weaponType: EnumWrapper<WeaponType>? = null,

    @Serializable(with = WeaponMaterialTypeContainerSerializer::class)
    val materialType: EnumWrapper<WeaponMaterialType>? = null,

    @Serializable(with = ElementContainerSerializer::class)
    val elemType: EnumWrapper<Element>? = null,

    val rankLevel: Int = UnsetInt,
    val isGold: Boolean? = null,
    val weaponBaseExp: Int = UnsetInt,
    val awakenMaterial: Int = UnsetInt,
    val appendPropNum: Int = UnsetInt,
    val skillAffix: List<Int>? = null,
    val weaponProp: List<WeaponProperty>? = null,
    val weaponPromoteId: Int = UnsetInt,
    val awakenCosts: List<Int>? = null,
    val enhanceRule: Int = UnsetInt,
    val initialLockState: Int = UnsetInt,



    // server only
    override val controlType: String? = null,
    override val itemRankLevel: Int = UnsetInt,

    // client only
    override val icon: String? = null,

    val awakenTexture: String? = null,
    val awakenLightMapTexture: String? = null,
    val awakenIcon: String? = null,
    val storyId: Int = UnsetInt,
    val unRotate: Boolean? = null,

    // TextHash
    val gachaCardNameHash: TextHash = UnsetTextHash,

    //TextMapHash
    override val nameTextMapHash: TextMapHash = UnsetTextMap,
    override val descTextMapHash: TextMapHash = UnsetTextMap,
    ) : ItemData, DestroyableItem, Strippable<WeaponData> {

    override fun strip(config: StripConfig): WeaponData = context(config) {
        copy(
            controlType = controlType.stripServerField(),

            icon = icon.stripClientField(),
            awakenTexture = awakenTexture.stripClientField(),
            awakenLightMapTexture = awakenLightMapTexture.stripClientField(),
            awakenIcon = awakenIcon.stripClientField(),
        )
    }
    @Serializable
    data class WeaponProperty(
        val initValue: Float = UnsetFloat,

        @Serializable(with = FightPropTypeContainerSerializer::class)
        val propType: EnumWrapper<FightPropType>? = null,
        @Serializable(with = GrowthCurveTypeContainerSerializer::class)
        val type: EnumWrapper<GrowthCurveType>? = null,
    )
}
