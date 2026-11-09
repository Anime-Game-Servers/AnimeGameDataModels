package org.anime_game_servers.game_data_models.gi.data.talks

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.gi.data.general.UnsetLong
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * TODO Add documentation
 * These are known names for files handled by this class:
 * ExcelBinOutput/TalkExcelConfigData.json
 * txt/TalkData*.txt (with an appropriate parser)
 */
@DataFile("ExcelBinOutput/TalkExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/TalkData*.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
@OptIn(ExperimentalSerializationApi::class)
data class TalkData(
    @JsonNames("_id")
    val id: Int,
    @JsonNames("_beginWay")
    val beginWay: String? = null,
    @JsonNames("_beginCondComb")
    val beginCondComb: String? = null,
    @JsonNames("_beginCond")
    val beginCond: List<BeginCond>? = null,
    @JsonNames("_heroTalk")
    val heroTalk: String? = null,
    @JsonNames("_loadType")
    val loadType: String? = null,
    @JsonNames("_activeMode")
    val activeMode: String? = null,
    @JsonNames("_nextTalks") // TODO check
    val nextTalks: List<Int>? = null,
    @JsonNames("_priority")
    val priority: Int = UnsetInt,
    @JsonNames("_initDialog")
    val initDialog: Long = UnsetLong,
    @JsonNames("_npcId", "npcId")
    val npcIds: List<Int>? = null,
    @JsonNames("_performCfg")
    val performCfg: String? = null,
    @JsonNames("_prePerformCfg")
    val prePerformCfg: String? = null,
    @JsonNames("_questId")
    val questId: Int = UnsetInt,
    @JsonNames("_decoratorID") // E.g. EJHGBAPGFHG
    val decoratorID: Int = UnsetInt,

    @JsonNames("_crowdLOD0List") // E.g. DGOJPEGIFOC
    val crowdLOD0List: List<Int>? = null,
    @JsonNames("_participantId")
    val participantId: List<Int>? = null,
    @JsonNames("_nextRandomTalks") // E.g. NECBIIDHGOA
    val nextRandomTalks: List<Int>? = null,
    @JsonNames("_showRandomTalkCount") // E.g. PBJHILLACIA
    val showRandomTalkCount: Int = UnsetInt,
    @JsonNames("_lockGameTime")
    val lockGameTime: Boolean? = null,
    @JsonNames("_finishExec")
    val finishExec: List<TalkExec>? = null,

    @JsonNames("_talkMarkType")
    val talkMarkType: String? = null,
    @JsonNames("_enableCameraDisplacement")
    val enableCameraDisplacement: Boolean? = null,
    @JsonNames("_stayFreeStyle")
    val stayFreeStyle: Boolean? = null,
    @JsonNames("_questIdleTalk")
    val questIdleTalk: Boolean? = null,
    @JsonNames("_lowPriority")
    val lowPriority: Boolean? = null,
    @JsonNames("_dontBlockDaily")
    val dontBlockDaily: Boolean? = null,

    // binout only:
    val assetIndex: Long = UnsetLong,

    // binout unknown (3.2)
    //val CIAAAKHILBD: List<Int>? = null,

    // excel only
    @JsonNames("_talkMarkHideList") // quests in talks with this set don't exist in binout
    val talkMarkHideList: List<Int>? = null,
    @JsonNames("_extraLoadMarkId") // talks  don't appear in the referenced quests in binout
    val extraLoadMarkId: List<Int>? = null,
    ) : IntKey {
    override fun getIntKey() = id
}

@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class BeginCond(
    // TODO create enum for type
    @JsonNames("type", "_type")
    val type: String? = null,
    @JsonNames("params", "_params", "_param")
    val params: List<String>? = null
)
