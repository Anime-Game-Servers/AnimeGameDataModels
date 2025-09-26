package org.anime_game_servers.game_data_models.gi.data.quest

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.TextMapHash
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.gi.data.general.UnsetLong
import org.anime_game_servers.game_data_models.gi.data.general.UnsetTextMap
import org.anime_game_servers.game_data_models.gi.data.talks.TalkData
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

@DataFile("ExcelBinOutput/MainQuestExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("BinOutput/Quest/*.json", FileType.JSON, FolderType.BINOUT)
@DataFile("txt/MainQuestData*.txt", FileType.TSV, FolderType.EXCEL)
@DataFile("Generated/Quest/*.json", FileType.JSON, FolderType.GENERATED)
@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class MainQuestData(
    @JsonNames("id", "mainId")
    val id: Int,

    val collectionId: Int = UnsetInt,
    val series: Int = UnsetInt,
    val chapterId: Int = UnsetInt,
    @JsonNames("taskType", "type")
    val taskType: String? = null, // TODO enum


    val luaPath: String? = null,
    @SerialName("recommendLevel")
    val recommendedLevel: Int = UnsetInt,
    val showType: String? = null,
    val repeatable: Boolean? = null,
    val suggestTrackOutOfOrder: Boolean? = null,
    val suggestTrackMainQuestList: List<Int>? = null,
    val rewardIdList: List<Int>? = null,
    val activeMode: String? = null,
    val activityId: Int = UnsetInt,
    val mainQuestTag: String? = null,
    val showRedPoint: Boolean? = null,
    @JsonNames("taskId", "taskID")
    val taskId: Int = UnsetInt,

    // Textmaps
    val titleTextMapHash: TextMapHash = UnsetTextMap,
    val descTextMapHash: TextMapHash = UnsetTextMap,

    // only txt
    val activityType: Int = UnsetInt,
    val videoKey: Long = UnsetLong,

    // only binout and patched
    val subQuests: List<SubQuestData>? = null,
    val talks: List<TalkData>? = null,
    val preloadLuaList : List<Long>? = null,
    val forcePreloadLuaList : List<Long>? = null,
    val freeStyleDic: Map<String, List<Int>>? = null,

    //TODO find content (3.2) first json value is MainQuestExcel, second is binout/Quest
    /*@JsonNames("KIODJCKJHHB", "EHPHJCINDBL")
    val KIODJCKJHHB: List<Int>? = null,
    @JsonNames("BJOJMLDHIGH", "DJKNKGBBFEH")
    val BJOJMLDHIGH: List<Int>? = null,
    @JsonNames("DDPIINIHIIP", "NNIEFFEDHHH")
    val DDPIINIHIIP: Int = -1,*/
): IntKey{
    override fun getIntKey() = id
}
