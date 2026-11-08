package org.anime_game_servers.game_data_models.gi.data.watcher

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.game_data_models.gi.helpers.getNonNull
import org.anime_game_servers.game_data_models.gi.helpers.getValueNonNull
import org.anime_game_servers.game_data_models.loader.enums.EnumWrapper

@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class WatcherTriggerConfig(
    @JsonNames("triggerType","TriggerType")
    @Serializable(with = WatcherTriggerTypeContainerSerializer::class)
    val triggerType: EnumWrapper<WatcherTriggerType>? = null,
    @JsonNames("paramList","Param")
    val paramList: List<String>?= null
) {
    fun getTriggerTypeNonNull() = triggerType.getValueNonNull(WatcherTriggerTypeMetadata)
    fun getParamListNonNull() = paramList.getNonNull()

}
