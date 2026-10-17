@file:OptIn(ExperimentalSerializationApi::class)

package org.anime_game_servers.game_data_models.gi.data.dungeon

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey

@Serializable
enum class DungeonEntrySatisfiedConditionType(val id: Int): IntKey {
    DUNGEON_ENTRY_CONDITION_NONE(0),
    DUNGEON_ENTRY_CONDITION_LEVEL(1),
    DUNGEON_ENTRY_CONDITION_QUEST(2),
    DUNGEON_ENTRY_CONDITION_UNKNOWN(9999);

    override fun getIntKey() = id
}