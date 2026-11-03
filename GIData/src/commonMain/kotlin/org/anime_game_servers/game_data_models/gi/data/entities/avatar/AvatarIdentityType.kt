package org.anime_game_servers.game_data_models.gi.data.entities.avatar

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

/**
 * TODO documentation
 */
@DataEnum
@Serializable
enum class AvatarIdentityType(val id: Int): IntKey {
    AVATAR_IDENTITY_MASTER(0),
    AVATAR_IDENTITY_NORMAL(1),

    @UnknownEntry
    AVATAR_IDENTITY_UNKNOWN(99999);

    override fun getIntKey() = id
}
