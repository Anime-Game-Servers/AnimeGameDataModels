package org.anime_game_servers.game_data_models.gi.data.activity.echo_shell

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

/**
 * TODO document
 */
@DataEnum
@Serializable
enum class EchoShellType(val id: Int) : IntKey {
    ECHO_SHELL_TYPE_NORMAL_ECHO(0),
    ECHO_SHELL_TYPE_SPECIAL_ECHO(1),
    ECHO_SHELL_TYPE_NORMAL_IMAGE(2),
    ECHO_SHELL_TYPE_SPECIAL_IMAGE(3),
    ECHO_SHELL_TYPE_NORMAL_INTERACT(4),

    @UnknownEntry
    ECHO_SHELL_TYPE_UNKNOWN(9999);

    override fun getIntKey() = id
}
