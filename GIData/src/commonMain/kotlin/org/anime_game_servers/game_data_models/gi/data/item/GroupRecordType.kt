package org.anime_game_servers.game_data_models.gi.data.item

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

@DataEnum
@Serializable
enum class GroupRecordType(val id: Int) : IntKey {
    @NoneEntry
    GROUP_RECORD_TYPE_NONE(0),
    GROUP_RECORD_TYPE_RACING(1),
    GROUP_RECORD_TYPE_BALLOON(2),
    GROUP_RECORD_TYPE_STAKE(3),
    GROUP_RECORD_TYPE_SEEK(4),
    GROUP_RECORD_TYPE_EXPLOSION(5),

    @UnknownEntry
    GROUP_RECORD_TYPE_UNKNOWN(9999);

    override fun getIntKey() = id
}
