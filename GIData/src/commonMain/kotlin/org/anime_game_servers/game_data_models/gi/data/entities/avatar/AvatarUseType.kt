package org.anime_game_servers.game_data_models.gi.data.entities.avatar

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

@DataEnum
@Serializable
enum class AvatarUseType(val id: Int): IntKey {
    AVATAR_TEST(0),
    AVATAR_SYNC_TEST(1),
    AVATAR_FORMAL(2),
    AVATAR_ABANDON(3),

    @UnknownEntry
    AVATAR_UNKNOWN(99999);

    override fun getIntKey() = id
}
