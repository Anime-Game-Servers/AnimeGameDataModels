package org.anime_game_servers.game_data_models.gi.data.quest

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

@DataEnum
@Serializable
enum class QuestState(val id: Int) : IntKey {
    @NoneEntry
    QUEST_STATE_NONE(0),
    QUEST_STATE_UNSTARTED(1),
    QUEST_STATE_UNFINISHED(2),
    QUEST_STATE_FINSHED(3),
    QUEST_STATE_FAILED(4),
    @UnknownEntry
    QUEST_STATE_UNKNOWN(9999);

    override fun getIntKey() = id
}
