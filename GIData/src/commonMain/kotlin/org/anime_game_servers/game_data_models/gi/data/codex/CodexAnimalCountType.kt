@file:OptIn(ExperimentalSerializationApi::class)

package org.anime_game_servers.game_data_models.gi.data.codex

import kotlinx.serialization.ExperimentalSerializationApi
import org.anime_game_servers.core.base.interfaces.IntKey

enum class CodexAnimalCountType(val id: Int): IntKey {
    CODEX_COUNT_TYPE_NONE(0),
    CODEX_COUNT_TYPE_KILL(1),
    CODEX_COUNT_TYPE_FISH(2),
    CODEX_COUNT_TYPE_CAPTURE(3),
    CODEX_COUNT_TYPE_UNKNOWN(9999);

    override fun getIntKey() = id
}