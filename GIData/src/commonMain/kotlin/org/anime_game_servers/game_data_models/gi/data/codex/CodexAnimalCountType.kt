package org.anime_game_servers.game_data_models.gi.data.codex

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

@DataEnum
@Serializable
enum class CodexAnimalCountType(val id: Int): IntKey {
    @NoneEntry
    CODEX_COUNT_TYPE_NONE(0),
    CODEX_COUNT_TYPE_KILL(1),
    CODEX_COUNT_TYPE_FISH(2),
    CODEX_COUNT_TYPE_CAPTURE(3),

    @UnknownEntry
    CODEX_COUNT_TYPE_UNKNOWN(9999);

    override fun getIntKey() = id
}