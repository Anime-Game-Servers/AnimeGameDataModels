package org.anime_game_servers.game_data_models.gi.data.item

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

@DataEnum
@Serializable
enum class FoodQualityType(val id: Int) : IntKey {
    @NoneEntry
    FOOD_QUALITY_NONE(0),
    FOOD_QUALITY_STRANGE(1),
    FOOD_QUALITY_ORDINARY(2),
    FOOD_QUALITY_DELICIOUS(3),

    @UnknownEntry
    FOOD_QUALITY_UNKNOWN(9999);

    override fun getIntKey() = id
}
