package org.anime_game_servers.game_data_models.gi.data.scene.challenge

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.helpers.enumValueOfOrDefault
import kotlin.jvm.JvmStatic

@Serializable
enum class SubChallengeBannerType(val id: Int) : IntKey {
    SUBCHALLENGE_BANNER_TYPE_NONE(0),
    SUBCHALLENGE_BANNER_TYPE_SUCCESS(1),
    SUBCHALLENGE_BANNER_TYPE_FAIL(2),
    SUBCHALLENGE_BANNER_TYPE_SHOW_FINAL(3),
    SUBCHALLENGE_BANNER_TYPE_HIDE_FINAL(4),

    /**
     * This is used when the type is unknown to the library, check the string version of the field to see what it contained
     */
    SUBCHALLENGE_BANNER_TYPE_UNKNOWN(9999);

    override fun getIntKey() = id
}