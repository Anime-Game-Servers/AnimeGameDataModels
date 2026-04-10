package org.anime_game_servers.game_data_models.gi.data.scene.challenge

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.helpers.enumValueOfOrDefault
import kotlin.jvm.JvmStatic

@Serializable
enum class SubChallengeAnimationType(val id: Int) : IntKey {
    SUB_CHALLENGE_ANIM_TYPE_DEFAULT(0),
    SUB_CHALLENGE_ANIM_TYPE_FORBID(1),
    SUB_CHALLENGE_ANIM_TYPE_SUCCESS(2),
    SUB_CHALLENGE_ANIM_TYPE_FAIL(3),

    /**
     * This is used when the type is unknown to the library, check the string version of the field to see what it contained
     */
    SUB_CHALLENGE_ANIM_TYPE_UNKNOWN(9999);

    override fun getIntKey() = id
}