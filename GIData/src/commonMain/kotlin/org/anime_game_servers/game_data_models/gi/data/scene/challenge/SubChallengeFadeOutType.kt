package org.anime_game_servers.game_data_models.gi.data.scene.challenge

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.helpers.enumValueOfOrDefault
import kotlin.jvm.JvmStatic

@Serializable
enum class SubChallengeFadeOutType(val id: Int) : IntKey {

    SUBCHALLENGE_FADEOUT_TYPE_NONE(0),
    SUBCHALLENGE_FADEOUT_TYPE_SUCCESS(1),
    SUBCHALLENGE_FADEOUT_TYPE_FAIL(2),
    SUBCHALLENGE_FADEOUT_TYPE_FINISH(3),

    /**
     * This is used when the type is unknown to the library, check the string version of the field to see what it contained
     */
    SUBCHALLENGE_FADEOUT_TYPE_UNKNOWN(9999);

    override fun getIntKey() = id
}