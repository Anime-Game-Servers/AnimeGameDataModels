@file:OptIn(ExperimentalSerializationApi::class)

package org.anime_game_servers.game_data_models.gi.data.quest

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.*
import org.anime_game_servers.game_data_models.gi.data.activity.ActivityData
import org.anime_game_servers.game_data_models.gi.serializers.StringToLocalDatetimeSerializer
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * This contains information for handling chapters, this includes info about when to notify the client about a chapter starting and ending.
 * 
 * These are known names for files handled by this class:
 * ExcelBinOutput/ChapterExcelConfigData.json
 * txt/ChapterData*.txt (with an appropriate parser)
 * @property id id of this chapter
 * @property beginQuestId [SubQuestData.subId] of the quest that should show the start chapter banner
 * @property endQuestId [SubQuestData.subId] of the quest that should show the end chapter banner
 * @property needPlayerLevel Player level required to start this chapter
 * @property inActivityNeedPlayerLevel During some events the level requirement for starting a chapter can be lowered
 * @property activityId [ActivityData.activityId] of the event this chapter belongs to
 * @property needBeginTimeStr TODO
 * @property chapterIcon TODO
 * @property chapterSerialNumberIcon TODO
 * @property chapterImageHash TODO
 * @property chapterNumTextMapHash TODO
 * @property chapterTitleTextMapHash TODO
 * @property chapterImageTitleTextMapHash TODO
 */
@DataFile("ExcelBinOutput/ChapterExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/ChapterData*.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class ChapterData(
    val id:Int,
    val beginQuestId: Int = UnsetInt,
    val endQuestId: Int = UnsetInt,
    val needPlayerLevel: Int = UnsetInt,
    val inActivityNeedPlayerLevel: Int = UnsetInt,
    val activityId: Int = UnsetInt,
    @Serializable(with = StringToLocalDatetimeSerializer::class)
    val needBeginTimeStr: LocalDateTime? = null,

    // client only
    val chapterIcon: String? = null,
    val chapterSerialNumberIcon: String? = null,

    // Texthashes
    val chapterImageHash: TextHash? = UnsetTextHash,

    //TextMapHash
    val chapterNumTextMapHash: TextMapHash = UnsetTextMap,
    val chapterTitleTextMapHash: TextMapHash = UnsetTextMap,
    val chapterImageTitleTextMapHash: TextMapHash = UnsetTextMap,
    ) : IntKey {
    override fun getIntKey() = id

    fun hasBeginQuestId() = beginQuestId != UnsetInt
    fun hasEndQuestId() = endQuestId != UnsetInt
    fun hasPlayerLevelRequirement() = needPlayerLevel > 0
    fun hasActivityPlayerLevelRequirement() = inActivityNeedPlayerLevel > 0
    fun hasActivityId() = activityId != UnsetInt
}
