package org.anime_game_servers.game_data_models.gi.data.general

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

/**
 * This represents the rarity/quality/stars of something (e.g. character or buff).
 */
@DataEnum
@Serializable
enum class QualityType(val id: Int): IntKey {
    @NoneEntry
    QUALITY_NONE(0),

    /**
     * White quality, also known as 1 Star.
     */
    QUALITY_WHITE(1),

    /**
     * Green quality, also known as 2 Star.
     */
    QUALITY_GREEN(2),

    /**
     * Blue quality, also known as 3 Star.
     */
    QUALITY_BLUE(3),

    /**
     * Purple quality, also known as 4 Star.
     */
    QUALITY_PURPLE(4),

    /**
     * Orange quality, also known as 5 Star.
     */
    QUALITY_ORANGE(5),

    /**
     * Special orange/5 Star quality, for example used for special promotion characters like Aloy
     */
    QUALITY_ORANGE_SP(105),

    @UnknownEntry
    QUALITY_UNKNOWN(99999);

    override fun getIntKey() = id
}
