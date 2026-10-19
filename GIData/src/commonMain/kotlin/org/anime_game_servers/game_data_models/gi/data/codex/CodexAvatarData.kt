package org.anime_game_servers.game_data_models.gi.data.codex

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.Element
import org.anime_game_servers.game_data_models.gi.data.general.TextMapHash
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.gi.data.general.UnsetTextMap
import org.anime_game_servers.game_data_models.gi.data.quest.GainItem
import org.anime_game_servers.game_data_models.gi.data.rewards.RewardData
import org.anime_game_servers.game_data_models.gi.data.rewards.RewardPreviewData
import org.anime_game_servers.game_data_models.gi.data.city.CityData
import org.anime_game_servers.game_data_models.gi.data.dungeon.DungeonPlayType
import org.anime_game_servers.game_data_models.gi.data.dungeon.DungeonStateType
import org.anime_game_servers.game_data_models.gi.data.dungeon.DungeonSubType
import org.anime_game_servers.game_data_models.gi.data.dungeon.DungeonType
import org.anime_game_servers.game_data_models.gi.data.dungeon.InvolveType
import org.anime_game_servers.game_data_models.gi.data.dungeon.SettleShowType
import org.anime_game_servers.game_data_models.gi.data.dungeon.SettleUIType
import org.anime_game_servers.game_data_models.gi.helpers.getNonNull
import org.anime_game_servers.game_data_models.gi.helpers.nullableEnumValueOfOrDefault
import org.anime_game_servers.game_data_models.gi.serializers.StringToLocalDatetimeSerializer
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * TODO
 * These are known names for files handled by this class:
 * ExcelBinOutput/AvatarCodexExcelConfigData.json
 * txt/AvatarCodexData.txt (with an appropriate parser)
 */
@OptIn(ExperimentalSerializationApi::class)
@DataFile("ExcelBinOutput/AvatarCodexExcelConfigData.json", JSON, EXCEL)
@DataFile("txt/AvatarCodexData.txt", TSV, EXCEL)
@Serializable
data class CodexAvatarData(
    @JsonNames("Id", "id")
    val avatarId: Int,
    val sortFactor: Int = UnsetInt,
    val sortId: Int = UnsetInt,
    val hideWhenDontHave: Boolean? = null,

    @Serializable(with = StringToLocalDatetimeSerializer::class)
    @JsonNames("begin_time")
    val beginTime: LocalDateTime? = null,
) : IntKey {
    override fun getIntKey() = avatarId

    fun getHideWhenDontHaveNonNull() = hideWhenDontHave.getNonNull()
}
