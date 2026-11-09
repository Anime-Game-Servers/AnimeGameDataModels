package org.anime_game_servers.game_data_models.gi.data.entities.avatar

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.*
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * This contains some information about the costumes/skins of characters/avatars.
 * These are known names for files handled by this class:
 * ExcelBinOutput/AvatarCostumeExcelConfigData.json
 * txt/AvatarCostumeData.txt
 * @property skinId The id of the costume/skin and primary identifier
 * @property indexId The index used to sort the skins in the UI todo verify
 * @property itemId the item id used to give a player this skin
 * @property characterId The [AvatarData] id of the character this skin belongs to
 * @property jsonName TODO document
 * @property quality The quality/Stars of the skin
 * @property isDefault If this skin is the default skin for the character
 * @property isDefaultUnlock used to determine if a non default skin is unlocked by default
 * @property hide If this skin is hidden
 * @property frontIconName TODO document
 * @property sideIconName TODO document
 * @property nameTextMapHash The [TextMapHash] of the name of the skin, that can be shown in the UI
 * @property descTextMapHash The [TextMapHash] of the description of the skin, that can be shown in the UI
 * @property prefabPathHash TODO document
 * @property prefabRemotePathHash TODO document
 * @property prefabNpcPathHash TODO document
 * @property animatorConfigPathHash TODO document
 * @property prefabMannequinPathHash TODO document
 * @property controllerPathHash TODO document
 * @property controllerRemotePathHash TODO document
 * @property imageNameHash TODO document
 */
@DataFile("ExcelBinOutput/AvatarCostumeExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/AvatarCostumeData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
@OptIn(ExperimentalSerializationApi::class)
data class AvatarCostumeData(
    @JsonNames("id", "skin_id", "costumeId", "costume_id")
    val skinId: Int,
    val indexId: Int = UnsetInt,
    val itemId: Int = UnsetInt,
    val characterId: Int = UnsetInt,
    val jsonName: String? = null,
    val quality: Int = UnsetInt,
    val isDefault: Boolean = false,
    val isDefaultUnlock: Boolean = false,
    val hide: Boolean = false,
    val frontIconName: String? = null,
    val sideIconName: String? = null,

    //textMaps
    val nameTextMapHash: TextMapHash = UnsetTextMap,
    val descTextMapHash: TextMapHash = UnsetTextMap,

    //textHashes
    @JsonNames("prefab_pathHash")
    val prefabPathHash: TextHash = UnsetTextHash,
    @JsonNames("prefab_remote_pathHash")
    val prefabRemotePathHash: TextHash = UnsetTextHash,
    @JsonNames("prefab_npc_pathHash")
    val prefabNpcPathHash: TextHash = UnsetTextHash,
    @JsonNames("animator_config_pathHash")
    val animatorConfigPathHash: TextHash = UnsetTextHash,
    @JsonNames("prefab_manekin_pathHash", "prefabManekinPathHash")
    val prefabMannequinPathHash: TextHash = UnsetTextHash,
    @JsonNames("controller_pathHash")
    val controllerPathHash: TextHash = UnsetTextHash,
    @JsonNames("controller_remote_pathHash")
    val controllerRemotePathHash: TextHash = UnsetTextHash,
    @JsonNames("image_name_hash")
    val imageNameHash: TextHash = UnsetTextHash,

    ): IntKey {
    override fun getIntKey() = skinId
}
