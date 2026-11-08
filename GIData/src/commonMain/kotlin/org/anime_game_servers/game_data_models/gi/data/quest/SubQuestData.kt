package org.anime_game_servers.game_data_models.gi.data.quest

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.LogicType
import org.anime_game_servers.game_data_models.gi.data.general.LogicTypeContainerSerializer
import org.anime_game_servers.game_data_models.gi.data.general.TextMapHash
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.gi.data.general.UnsetTextMap
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType
import org.anime_game_servers.game_data_models.loader.enums.EnumWrapper

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
    @Serializable(with = LogicTypeContainerSerializer::class)
    val acceptCondComb: EnumWrapper<LogicType>? = null,
    val acceptCond: List<QuestCondition>? = null,

    @Serializable(with = LogicTypeContainerSerializer::class)
    val finishCondComb: EnumWrapper<LogicType>? = null,
    val finishCond: List<QuestContent>? = null,

    @Serializable(with = LogicTypeContainerSerializer::class)
    val failCondComb: EnumWrapper<LogicType>? = null,
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
