package org.anime_game_servers.game_data_models.gi.data.entities.avatar

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.Version.GI_5_7_0
import org.anime_game_servers.core.base.annotations.AddedIn
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.*
import org.anime_game_servers.game_data_models.gi.helpers.nullableEnumValueOfOrDefault
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

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
 * @property weaponTypeString weapon type this skin is applied to
 * @property weaponType enum representation of [weaponTypeString]. [WeaponType.WEAPON_UNKNOWN] if set to something not in the enum
 * @property tagTypeString TODO document
 * @property tagType enum representation of [tagTypeString]. [WeaponSkinTagType.TAG_TYPE_UNKNOWN] if set to something not in the enum
 * @property displayTypeString TODO document
 * @property displayType  [displayTypeString]. [WeaponSkinDisplayType.USE_TIME_TYPE_UNKNOWN] if set to something not in the enum
 * @property useTimeTypeString TODO document
 * @property useTimeType  [useTimeTypeString]. [WeaponSkinUseTimeType.USE_TIME_TYPE_UNKNOWN] if set to something not in the enum
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

    @SerialName("qualityType")
    val weaponTypeString: String? = null,
    @Transient
    val weaponType: WeaponType? = nullableEnumValueOfOrDefault(weaponTypeString, WeaponType.WEAPON_UNKNOWN),

    @SerialName("tagType")
    val tagTypeString: String? = null,
    @Transient
    val tagType: WeaponSkinTagType? = nullableEnumValueOfOrDefault(tagTypeString, WeaponSkinTagType.TAG_TYPE_UNKNOWN),

    @SerialName("displayType")
    val displayTypeString: String? = null,
    @Transient
    val displayType: WeaponSkinDisplayType? = nullableEnumValueOfOrDefault(displayTypeString, WeaponSkinDisplayType.USE_TIME_TYPE_UNKNOWN),

    @SerialName("useTimeType")
    val useTimeTypeString: String? = null,
    @Transient
    val useTimeType: WeaponSkinUseTimeType? = nullableEnumValueOfOrDefault(useTimeTypeString, WeaponSkinUseTimeType.USE_TIME_TYPE_UNKNOWN),

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
