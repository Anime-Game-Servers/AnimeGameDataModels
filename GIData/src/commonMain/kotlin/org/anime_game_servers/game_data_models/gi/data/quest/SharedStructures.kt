package org.anime_game_servers.game_data_models.gi.data.quest

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.core.base.interfaces.StringKey
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.gi.helpers.nullableEnumValueOfOrDefault

@Serializable
@OptIn(ExperimentalSerializationApi::class)
data class QuestContent(
    @SerialName("type")
    @JsonNames("type", "_type")
    val typeString: String? = null,
    @Transient
    val type: QuestContentType? = nullableEnumValueOfOrDefault(typeString, QuestContentType.QUEST_CONTENT_UNKNOWN),
    @JsonNames("param_str", "_param_str")
    val paramString: String? = null,
    @JsonNames("param", "_param")
    val param: List<Int>? = null,
    @JsonNames("count", "_count")
    val count: Int = UnsetInt
) : StringKey {
    override fun getStringKey() = (typeString ?: "")+(param?.getOrNull(0) ?: "")
}
@Serializable
@OptIn(ExperimentalSerializationApi::class)
data class QuestCondition(
    @SerialName("type")
    @JsonNames("type", "_type")
    val typeString: String? = null,
    @Transient
    val type: QuestCondType? = nullableEnumValueOfOrDefault(typeString, QuestCondType.QUEST_COND_UNKNOWN),
    @JsonNames("param", "_param")
    val param: List<Int>? = null,
) : StringKey {
    override fun getStringKey() = (typeString ?: "")+(param?.getOrNull(0) ?: "")
}

@Serializable
@OptIn(ExperimentalSerializationApi::class)
data class QuestExec(
    @SerialName("type")
    @JsonNames("type", "_type")
    val typeString: String? = null,
    @Transient
    val type: QuestExecType? = nullableEnumValueOfOrDefault(typeString, QuestExecType.QUEST_EXEC_UNKNOWN),
    @JsonNames("param", "_param")
    val param: List<String>? = null
)

@Serializable
@OptIn(ExperimentalSerializationApi::class)
data class QuestGuide(
    @SerialName("type")
    @JsonNames("type", "_type")
    val typeString: String? = null,
    @Transient
    val type: QuestGuideType? = nullableEnumValueOfOrDefault(typeString, QuestGuideType.QUEST_GUIDE_UNKNOWN),
    @JsonNames("param", "_param")
    val param: List<String>? = null,
    val guideScene: Int = UnsetInt,
    val guideStyle: String? = null,
    val guideLayer: String? = null,
    val autoGuide: String? = null,
)

enum class QuestGuideType(val id: Int) : IntKey {
    QUEST_GUIDE_NONE(0),
    QUEST_GUIDE_LOCATION(1),
    QUEST_GUIDE_NPC(2),
    QUEST_GUIDE_GADGET(3),
    QUEST_GUIDE_SHOW_OR_HIDE_NPC(4),
    QUEST_GUIDE_DUNGEON_ENTRY(5),
    QUEST_GUIDE_UNKNOWN(9999);

    override fun getIntKey() = id
}

@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class GainItem (
    @JsonNames("id")
    val itemId: Int = UnsetInt,
    @JsonNames("itemCount", "itemNum")
    val count: Int = UnsetInt
) : IntKey{
    override fun getIntKey() = itemId
}
