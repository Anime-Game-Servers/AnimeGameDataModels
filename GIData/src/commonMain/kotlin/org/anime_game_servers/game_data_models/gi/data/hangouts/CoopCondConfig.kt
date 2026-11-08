@file:OptIn(ExperimentalSerializationApi::class)

package org.anime_game_servers.game_data_models.gi.data.hangouts

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.game_data_models.gi.helpers.getNonNull
import org.anime_game_servers.game_data_models.gi.helpers.getValueNonNull
import org.anime_game_servers.game_data_models.loader.enums.EnumWrapper


@Serializable
data class CoopCondConfig(
    @JsonNames("_condType")
    @Serializable(with = CoopTaskCondTypeContainerSerializer::class)
    val condType: EnumWrapper<CoopTaskCondType>? = null,
    val args: List<Int>? = null,
) {
    fun getCondTypeNonNull() = condType.getValueNonNull(CoopTaskCondTypeMetadata)
    fun getArgsNonNull() = args.getNonNull()
}