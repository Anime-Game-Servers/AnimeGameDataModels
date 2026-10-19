@file:OptIn(ExperimentalSerializationApi::class)

package org.anime_game_servers.game_data_models.gi.data.codex

import kotlinx.serialization.ExperimentalSerializationApi
import org.anime_game_servers.core.base.interfaces.IntKey

enum class CodexAnimalType(val id: Int): IntKey {
    CODEX_ANIMAL(0),
    CODEX_MONSTER(1),
    CODEX_UNKNOWN(9999);

    override fun getIntKey() = id
}