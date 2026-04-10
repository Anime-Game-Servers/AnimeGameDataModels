@file:OptIn(ExperimentalSerializationApi::class)

package org.anime_game_servers.game_data_models.gi.data.scene.challenge

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.helpers.enumValueOfOrDefault
import kotlin.jvm.JvmStatic

@Serializable
enum class SubChallengeSortType(val id: Int) : IntKey {
    SUB_CHALLENGE_SORT_TYPE_DEFAULT(0),
    @JsonNames("SUB_CHALLENGE_SORT_TYPE_CHALLENGEINDEX")
    SUB_CHALLENGE_SORT_TYPE_CHALLENGE_INDEX(1),

    /**
     * This is used when the type is unknown to the library, check the string version of the field to see what it contained
     */
    SUB_CHALLENGE_SORT_TYPE_UNKNOWN(9999);

    override fun getIntKey() = id
}