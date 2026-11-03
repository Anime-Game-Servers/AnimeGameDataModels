package org.anime_game_servers.game_data_models.gi.data.codex

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

@DataEnum
@Serializable
enum class CodexMaterialType(val id: Int): IntKey {
    CODEX_COLLECTION(0),
    CODEX_COOKING_FOOD(1),
    CODEX_WAR_TROPHIES(2),
    CODEX_WIDGET(3),

    @UnknownEntry
    CODEX_UNKNOWN(9999);

    override fun getIntKey() = id
}
