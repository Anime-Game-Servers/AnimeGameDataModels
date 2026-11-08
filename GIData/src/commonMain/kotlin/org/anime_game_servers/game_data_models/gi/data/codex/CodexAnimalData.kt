package org.anime_game_servers.game_data_models.gi.data.codex

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.TextMapHash
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.gi.data.general.UnsetTextMap
import org.anime_game_servers.game_data_models.gi.helpers.getNonNull
import org.anime_game_servers.game_data_models.gi.helpers.getValueNonNull
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType
import org.anime_game_servers.game_data_models.loader.enums.EnumWrapper

/**
 * TODO
 * These are known names for files handled by this class:
 * ExcelBinOutput/AnimalCodexExcelConfigData.json
 * txt/AnimnalCodexData.txt (with an appropriate parser)
 */
@OptIn(ExperimentalSerializationApi::class)
@DataFile("ExcelBinOutput/AnimalCodexExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/AnimnalCodexData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class CodexAnimalData(
    @JsonNames("Id")
    val id: Int,
    val describeId: Int = UnsetInt,
    @JsonNames("SortOrder")
    val sortOrder: Int = UnsetInt,
    val isDisuse: Boolean? = null,
    val showOnlyUnlocked: Boolean? = null,
    val isSeenActive: Boolean? = null,

    @Serializable(with = CodexAnimalTypeContainerSerializer::class)
    val type: EnumWrapper<CodexAnimalType>? = null,
    @Serializable(with = CodexAnimalCountTypeContainerSerializer::class)
    val countType: EnumWrapper<CodexAnimalCountType>? = null,

    // client only
    val pushTipsCodexId: Int = UnsetInt,
    val modelPath: String? = null,

    @Serializable(with = CodexAnimalSubTypeContainerSerializer::class)
    val subType: EnumWrapper<CodexAnimalSubType>? = null,

    // Textmaps
    val descTextMapHash: TextMapHash = UnsetTextMap,
) : IntKey {
    override fun getIntKey() = id

    fun isDisuseNonNull() = isDisuse.getNonNull()
    fun getShowOnlyUnlockedNonNull() = showOnlyUnlocked.getNonNull()
    fun isSeenActiveNonNull() = isSeenActive.getNonNull()

    fun getTypeNonNull() = type.getValueNonNull(CodexAnimalTypeMetadata)
    fun getCountTypeNonNull() = countType.getValueNonNull(CodexAnimalCountTypeMetadata)
    fun getSubTypeNonNull() = subType.getValueNonNull(CodexAnimalSubTypeMetadata)
}
