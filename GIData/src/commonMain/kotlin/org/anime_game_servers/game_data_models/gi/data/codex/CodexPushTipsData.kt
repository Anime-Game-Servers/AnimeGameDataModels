package org.anime_game_servers.game_data_models.gi.data.codex

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.gi.helpers.getNonNull
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * TODO
 * These are known names for files handled by this class:
 * ExcelBinOutput/PushTipsCodexExcelConfigData.json
 * txt/PushTipsCodexData.txt (with an appropriate parser)
 */
@OptIn(ExperimentalSerializationApi::class)
@DataFile("ExcelBinOutput/PushTipsCodexExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/PushTipsCodexData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class CodexPushTipsData(
    @JsonNames("Id")
    val id: Int,
    val pushTipId: Int = UnsetInt,
    @JsonNames("SortOrder")
    val sortOrder: Int = UnsetInt,
    val isDisuse: Boolean? = null,
) : IntKey {
    override fun getIntKey() = id

    fun isDisuseNonNull() = isDisuse.getNonNull()
}
