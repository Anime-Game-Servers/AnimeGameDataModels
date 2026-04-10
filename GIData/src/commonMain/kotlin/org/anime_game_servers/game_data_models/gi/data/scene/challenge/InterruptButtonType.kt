package org.anime_game_servers.game_data_models.gi.data.scene.challenge

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.helpers.enumValueOfOrDefault
import kotlin.jvm.JvmStatic

@Serializable
enum class InterruptButtonType(val id: Int) : IntKey {
    INTERRUPT_BUTTON_TYPE_NONE(0),
    INTERRUPT_BUTTON_TYPE_HOST(1),
    INTERRUPT_BUTTON_TYPE_ALL(2),

    /**
     * This is used when the type is unknown to the library, check the string version of the field to see what it contained
     */
    INTERRUPT_UNKNOWN(9999);

    override fun getIntKey() = id
}