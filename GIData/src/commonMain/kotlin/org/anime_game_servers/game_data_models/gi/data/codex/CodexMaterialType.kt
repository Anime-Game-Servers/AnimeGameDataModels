@file:OptIn(ExperimentalSerializationApi::class)

package org.anime_game_servers.game_data_models.gi.data.codex

import kotlinx.serialization.ExperimentalSerializationApi
import org.anime_game_servers.core.base.interfaces.IntKey

enum class CodexMaterialType(val id: Int): IntKey {
    CODEX_COLLECTION(0),
    CODEX_COOKING_FOOD(1),
    CODEX_WAR_TROPHIES(2),
    CODEX_WIDGET(3),
    CODEX_UNKNOWN(9999);

    override fun getIntKey() = id
}