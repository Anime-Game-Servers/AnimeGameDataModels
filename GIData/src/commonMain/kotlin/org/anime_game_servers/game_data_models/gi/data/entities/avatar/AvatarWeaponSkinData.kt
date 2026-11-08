package org.anime_game_servers.game_data_models.gi.data.entities.avatar

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.Version.GI_5_7_0
import org.anime_game_servers.core.base.annotations.AddedIn
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.*
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType
import org.anime_game_servers.game_data_models.loader.enums.EnumWrapper

/**
 * This contains some information about the weapon skins.
 * These are known names for files handled by this class:
 * ExcelBinOutput/AvatarWeaponSkinExcelConfigData.json
 * txt/AvatarWeaponSkinData.txt
 * @property weaponSkinId The id of the weapon skin and primary identifier
 * @property itemId item id of the item this skin is attached to
 * @property jsonName TODO document
 * @property iconPath TODO document
 * @property imagePath TODO document
 * @property quality The quality/Stars of the skin
 * @property sortId id used for sorting in the ui
 * @property unRotate TODO document
 *
 * @property weaponType [WeaponType.WEAPON_UNKNOWN] if set to something not in the enum // todo document
 * @property tagType [WeaponSkinTagType.TAG_TYPE_UNKNOWN] if set to something not in the enum  // todo document
 * @property displayType [WeaponSkinDisplayType.USE_TIME_TYPE_UNKNOWN] if set to something not in the enum  // todo document
 * @property useTimeType [WeaponSkinUseTimeType.USE_TIME_TYPE_UNKNOWN] if set to something not in the enum  // todo document
 *
 * @property nameTextMapHash The [TextMapHash] of the name of the skin, that can be shown in the UI
 * @property descTextMapHash The [TextMapHash] of the description of the skin, that can be shown in the UI
 *
 * @property prefabPathHash TODO document
 *
 * @property unk_57_EAFKNGDLCNP TODO document
 * @property unk_57_LMEGOGPGCFO TODO document
 * @property unk_57_FBHKOEGMENJ TODO document
 * @property unk_57_NGJNPGDBPAK TODO document
 * @property unk_57_DEJNMGKNPAG TODO document
 * @property unk_57_BPBECLHPLCC TODO document
 * @property unk_57_CJKHAJBDEEK TODO document
 * @property unk_57_HLDDKGKNADI TODO document
 * @property unk_51_LMGDLLGEGJI TODO document 5.1 was the first usage in excel files of this, but it might have been used earlier internally
 */
@DataFile("ExcelBinOutput/AvatarWeaponSkinExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/AvatarWeaponSkinData.txt", FileType.TSV, FolderType.EXCEL)
@AddedIn(GI_5_7_0)
@Serializable
@OptIn(ExperimentalSerializationApi::class)
data class AvatarWeaponSkinData(
    @JsonNames("id", "skin_id", "weapon_skin_id")
    val weaponSkinId: Int,
    val itemId: Int = UnsetInt,
    val jsonName: String? = null,
    val iconPath: String? = null,
    val imagePath: String? = null,
    val quality: Int = UnsetInt,
    val sortId: Int = UnsetInt,
    val unRotate: Boolean = false,

    @Serializable(with = WeaponTypeContainerSerializer::class)
    val weaponType: EnumWrapper<WeaponType>? = null,
    @Serializable(with = WeaponSkinTagTypeContainerSerializer::class)
    val tagType: EnumWrapper<WeaponSkinTagType>? = null,
    @Serializable(with =WeaponSkinDisplayTypeContainerSerializer::class)
    val displayType: EnumWrapper<WeaponSkinDisplayType>? = null,
    @Serializable(with = WeaponSkinUseTimeTypeContainerSerializer::class)
    val useTimeType: EnumWrapper<WeaponSkinUseTimeType>? = null,

    //textMaps
    val nameTextMapHash: TextMapHash = UnsetTextMap,
    val descTextMapHash: TextMapHash = UnsetTextMap,

    //textHashes
    @JsonNames("prefab_pathHash")
    val prefabPathHash: TextHash = UnsetTextHash,

    // not yet named fields
    val unk_57_EAFKNGDLCNP: List<Int>? = null,
    val unk_57_LMEGOGPGCFO: List<Int>? = null,
    val unk_57_FBHKOEGMENJ: String? = null,
    val unk_57_NGJNPGDBPAK: String? = null,
    val unk_57_DEJNMGKNPAG: String? = null,
    val unk_57_BPBECLHPLCC: String? = null,
    val unk_57_CJKHAJBDEEK: String? = null,
    val unk_57_HLDDKGKNADI: Boolean = false,
    val unk_51_LMGDLLGEGJI: Boolean = false,
    ): IntKey {
    override fun getIntKey() = weaponSkinId
}
