package org.anime_game_servers.game_data_models.gi.data.activity

import kotlinx.serialization.Serializable
import org.anime_game_servers.game_data_models.gi.helpers.getNonNull
import org.anime_game_servers.game_data_models.gi.helpers.getValueNonNull
import org.anime_game_servers.game_data_models.loader.enums.EnumWrapper

@Serializable
data class ActivityShopSheetCond(
    @Serializable(with = ActivityShopSheetCondTypeContainerSerializer::class)
    val type: EnumWrapper<ActivityShopSheetCondType>? = null,
    val param: List<Int>? = null
) {
    fun getTypeNonNull() = type.getValueNonNull(ActivityShopSheetCondTypeMetadata)
    fun getParamNonNull() = param.getNonNull()
}
