package org.anime_game_servers.game_data_models.gi.data.quest

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.LogicType
import org.anime_game_servers.game_data_models.gi.data.general.TextMapHash
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.gi.data.general.UnsetTextMap
import org.anime_game_servers.game_data_models.gi.helpers.nullableEnumValueOfOrDefault
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

@DataFile("ExcelBinOutput/QuestExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/QuestData*.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class SubQuestData(
    val subId: Int,
    val mainId: Int,
    val order: Int = UnsetInt,
    val subIdSet: Int = UnsetInt,
    val isMpBlock: Boolean? = null,
    val showType: String? = null,
    val failParentShow: String? = null,
    val finishParent: Boolean? = null,
    val failParent: Boolean? = null,
    val isRewind: Boolean? = null,

    val luaPath: String? = null, // binout
    val trialAvatarList: List<Int>? = null,

    val versionBegin: String? = null,
    val versionEnd: String? = null,

    // quest conditions
    @SerialName("acceptCondComb")
    val acceptCondCombString: String? = null,
    @Transient
    val acceptCondComb: LogicType? = nullableEnumValueOfOrDefault(acceptCondCombString, LogicType.LOGIC_UNKNOWN),
    val acceptCond: List<QuestCondition>? = null,
    @SerialName("finishCondComb")
    val finishCondCombString: String? = null,
    @Transient
    val finishCondComb: LogicType? = nullableEnumValueOfOrDefault(finishCondCombString, LogicType.LOGIC_UNKNOWN),
    val finishCond: List<QuestContent>? = null,
    @SerialName("failCondComb")
    val failCondCombString: String? = null,
    @Transient
    val failCondComb: LogicType? = nullableEnumValueOfOrDefault(failCondCombString, LogicType.LOGIC_UNKNOWN),
    val failCond: List<QuestContent>? = null,


    // quest execs
    val beginExec: List<QuestExec>? = null,
    val finishExec: List<QuestExec>? = null,
    val failExec: List<QuestExec>? = null,

    val guide: QuestGuide? = null,
    val showGuide: String? = null,
    val banType: String? = null,
    val exclusiveNpcList: List<Int>? = null,
    val exclusiveNpcPriority: Int = UnsetInt,
    val sharedNpcList: List<Int>? = null,
    val exclusivePlaceList: List<Int>? = null,

    // Textmaps
    val descTextMapHash: TextMapHash = UnsetTextMap,
    val stepDescTextMapHash: TextMapHash = UnsetTextMap,
    val guideTipsTextMapHash: TextMapHash = UnsetTextMap,

    //custom elements
    var gainItems: List<GainItem>? = null,
    ) : IntKey {
        override fun getIntKey() = subId
    }
