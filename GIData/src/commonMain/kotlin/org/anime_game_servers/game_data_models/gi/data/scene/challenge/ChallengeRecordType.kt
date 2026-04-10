package org.anime_game_servers.game_data_models.gi.data.scene.challenge

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.helpers.enumValueOfOrDefault
import kotlin.jvm.JvmStatic

@Serializable
enum class ChallengeRecordType(val id: Int) : IntKey {
    CHALLENGE_RECORD_TYPE_NONE(0),
    CHALLENGE_RECORD_TYPE_IN_TIME(1),
    
    /**
     * This is used when the type is unknown to the library, check the string version of the field to see what it contained
     */
    CHALLENGE_RECORD_TYPE_UNKNOWN(9999);

    override fun getIntKey() = id
}