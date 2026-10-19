@file:OptIn(ExperimentalSerializationApi::class)

package org.anime_game_servers.game_data_models.gi.data.codex

import kotlinx.serialization.ExperimentalSerializationApi
import org.anime_game_servers.core.base.interfaces.IntKey

enum class CodexAnimalSubType(val id: Int): IntKey {
    CODEX_SUBTYPE_ELEMENTAL(0),
    CODEX_SUBTYPE_HILICHURL(1),
    CODEX_SUBTYPE_ABYSS(2),
    CODEX_SUBTYPE_FATUI(3),
    CODEX_SUBTYPE_AUTOMATRON(4),
    CODEX_SUBTYPE_HUMAN(5),
    CODEX_SUBTYPE_BEAST(6),
    CODEX_SUBTYPE_BOSS(7),
    CODEX_SUBTYPE_AVIARY(8),
    CODEX_SUBTYPE_ANIMAL(9),
    CODEX_SUBTYPE_FISH(10),
    CODEX_SUBTYPE_CRITTER(11),
    CODEX_SUBTYPE_UNKNOWN(9999);

    override fun getIntKey() = id
}