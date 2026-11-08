package org.anime_game_servers.game_data_models.gi.data.quest

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.core.base.interfaces.StringKey
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.EnumWrapper
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

@Serializable
@OptIn(ExperimentalSerializationApi::class)
data class QuestContent(
    @JsonNames("type", "_type")
    @Serializable(with = QuestContentTypeContainerSerializer::class)
    val type: EnumWrapper<QuestContentType>? = null,
    @JsonNames("param_str", "_param_str")
    val paramString: String? = null,
    @JsonNames("param", "_param")
    val param: List<Int>? = null,
    @JsonNames("count", "_count")
    val count: Int = UnsetInt
) : StringKey {
    override fun getStringKey() = (type?.key ?: "")+(param?.getOrNull(0) ?: "")
}
@Serializable
@OptIn(ExperimentalSerializationApi::class)
data class QuestCondition(
    @JsonNames("type", "_type")
    @Serializable(with = QuestCondTypeContainerSerializer::class)
    val type: EnumWrapper<QuestCondType>? = null,
    @JsonNames("param", "_param")
    val param: List<Int>? = null,
) : StringKey {
    override fun getStringKey() = (type?.key ?: "")+(param?.getOrNull(0) ?: "")
}

@Serializable
@OptIn(ExperimentalSerializationApi::class)
data class QuestExec(
    @JsonNames("type", "_type")
    @Serializable(with = QuestExecTypeContainerSerializer::class)
    val type: EnumWrapper<QuestExecType>? = null,
    @JsonNames("param", "_param")
    val param: List<String>? = null
)

@Serializable
@OptIn(ExperimentalSerializationApi::class)
data class QuestGuide(
    @JsonNames("type", "_type")
    @Serializable(with = QuestGuideTypeContainerSerializer::class)
    val type: EnumWrapper<QuestGuideType>? = null,
    @JsonNames("param", "_param")
    val param: List<String>? = null,
    val guideScene: Int = UnsetInt,
    val guideStyle: String? = null,
    val guideLayer: String? = null,
    val autoGuide: String? = null,
)

@DataEnum
@Serializable
enum class QuestGuideType(val id: Int) : IntKey {
    @NoneEntry
    QUEST_GUIDE_NONE(0),
    QUEST_GUIDE_LOCATION(1),
    QUEST_GUIDE_NPC(2),
    QUEST_GUIDE_GADGET(3),
    QUEST_GUIDE_SHOW_OR_HIDE_NPC(4),
    QUEST_GUIDE_DUNGEON_ENTRY(5),
    @UnknownEntry
    QUEST_GUIDE_UNKNOWN(9999);

    override fun getIntKey() = id
}

/**
 *
 * @param itemId Can reference the id of any element if the type [org.anime_game_servers.game_data_models.gi.data.item.ItemData]
 */
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
