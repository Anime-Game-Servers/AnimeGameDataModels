package org.anime_game_servers.game_data_models.gi.data.general

import org.anime_game_servers.core.base.interfaces.IntKey

enum class Element(val id:Int) : IntKey {
    NONE(0),
    FIRE(1),
    WATER(2),
    GRASS(3),
    ELECTRIC(4),
    ICE(5),
    FROZEN(6),
    WIND(7),
    ROCK(8),
    ANTI_FIRE(9),
    VehicleMuteIce(10),
    Mushroom(11),
    Overdose(12),
    Wood(13),
    LiquidPhlogiston(14),
    SolidPhlogiston(15),
    SolidifyPhlogiston(16),
    DEFAULT(255);

    override fun getIntKey() = id
}