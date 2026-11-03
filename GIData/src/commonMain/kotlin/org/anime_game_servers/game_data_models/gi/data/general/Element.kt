@file:OptIn(ExperimentalSerializationApi::class)

package org.anime_game_servers.game_data_models.gi.data.general

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

@DataEnum
@Serializable
enum class Element(val id:Int) : IntKey {
    @NoneEntry
    @JsonNames("None")
    NONE(0),
    @JsonNames("Fire")
    FIRE(1),
    @JsonNames("Water")
    WATER(2),
    @JsonNames("Grass")
    GRASS(3),
    @JsonNames("Electric")
    ELECTRIC(4),
    @JsonNames("ice")
    ICE(5),
    @JsonNames("Frozen")
    FROZEN(6),
    @JsonNames("Wind")
    WIND(7),
    @JsonNames("Rock")
    ROCK(8),
    @JsonNames("AntiFire")
    ANTI_FIRE(9),
    @JsonNames("VehicleMuteIce")
    VEHICLE_MUTE_ICE(10),
    @JsonNames("Mushroom")
    MUSHROOM(11),
    @JsonNames("Overdose")
    OVERDOSE(12),
    @JsonNames("Wood")
    WOOD(13),
    @JsonNames("LiquidPhlogiston")
    LIQUID_PHLOGISTON(14),
    @JsonNames("SolidPhlogiston")
    SOLID_PHLOGISTON(15),
    @JsonNames("SolidifyPhlogiston")
    SOLIDIFY_PHLOGISTON(16),
    @JsonNames("BrokenIce")
    BROKEN_ICE(17),


    // todo split default and unknown?
    @UnknownEntry
    DEFAULT(255);

    override fun getIntKey() = id
}
