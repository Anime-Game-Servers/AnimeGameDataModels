package org.anime_game_servers.game_data_models.gi.data.codex

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.TextMapHash
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.gi.data.general.UnsetTextMap
import org.anime_game_servers.game_data_models.gi.helpers.getNonNull
import org.anime_game_servers.game_data_models.gi.helpers.nullableEnumValueOfOrDefault
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * TODO
 * These are known names for files handled by this class:
 * ExcelBinOutput/MaterialCodexExcelConfigData.json
 * txt/MaterialCodexData.txt (with an appropriate parser)
 */
@OptIn(ExperimentalSerializationApi::class)
@DataFile("ExcelBinOutput/MaterialCodexExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/MaterialCodexData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class CodexMaterialData(
    @JsonNames("Id")
    val id: Int,
    val materialId: Int = UnsetInt,
    @JsonNames("SortOrder")
    val sortOrder: Int = UnsetInt,
    val isDisuse: Boolean? = null,
    val showOnlyUnlocked: Boolean? = null,
    val icon: String? = null,

    @SerialName("type")
    val typeString: String? = null,
    @Transient
    val type: CodexMaterialType? = nullableEnumValueOfOrDefault(typeString, CODEX_UNKNOWN),


    // Textmaps
    val nameTextMapHash: TextMapHash = UnsetTextMap,
    val descTextMapHash: TextMapHash = UnsetTextMap,
) : IntKey {
    override fun getIntKey() = id

    fun isDisuseNonNull() = isDisuse.getNonNull()
    fun getShowOnlyUnlockedNonNull() = showOnlyUnlocked.getNonNull()
}
