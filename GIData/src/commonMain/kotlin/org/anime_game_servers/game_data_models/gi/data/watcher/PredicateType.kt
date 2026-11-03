package org.anime_game_servers.game_data_models.gi.data.watcher

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

// TODO
@DataEnum
@Serializable
enum class PredicateType(val id: Int) : IntKey {
    @NoneEntry
    PREDICATE_NONE(0),
    PREDICATE_QUEST_FINISH(1),
    PREDICATE_CURRENT_AVATAR(2),
    PREDICATE_GCG_LEVEL(3),

    @UnknownEntry
    PREDICATE_UNKNOWN(9999);

    override fun getIntKey() = id
}
