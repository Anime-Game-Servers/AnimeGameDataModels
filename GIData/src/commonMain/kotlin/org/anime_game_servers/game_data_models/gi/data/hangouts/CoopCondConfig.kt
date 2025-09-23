@file:OptIn(ExperimentalSerializationApi::class)

package org.anime_game_servers.game_data_models.gi.data.hangouts

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.game_data_models.gi.helpers.nullableEnumValueOfOrDefault


@Serializable
data class CoopCondConfig(
    @SerialName("condType") @JsonNames("_condType")
    val condTypeString: String? = null,
    @Transient
    val condType: CoopTaskCondType? = nullableEnumValueOfOrDefault(condTypeString, CoopTaskCondType.COOP_COND_UNKNOWN),
    val args: List<Int>? = null,
)