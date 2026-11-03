@file:OptIn(ExperimentalSerializationApi::class)

package org.anime_game_servers.game_data_models.gi.data.item

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

@DataEnum
@Serializable
enum class FurnitureDeploySurfaceType(val id: Int) : IntKey {
    @JsonNames("Ground")
    GROUND(0),
    @JsonNames("Wall")
    WALL(1),
    @JsonNames("Ceil")
    CEIL(2),
    @JsonNames("StackObjPlane")
    STACK_OBJ_PLANE(3),
    @JsonNames("Door")
    DOOR(4),
    @JsonNames("Chandelier")
    CHANDELIER(5),
    @JsonNames("Floor")
    FLOOR(6),
    @JsonNames("WallBody")
    WALL_BODY(7),
    @JsonNames("Carpet")
    CARPET(8),
    @JsonNames("LegoRockery")
    LEGO_ROCKERY(9),
    @JsonNames("Stair")
    STAIR(10),
    NPC(11),
    @JsonNames("Animal")
    ANIMAL(12),
    @JsonNames("Apartment")
    APARTMENT(13),
    @JsonNames("FurnitureSuite")
    FURNITURE_SUITE(14),
    @JsonNames("Road")
    ROAD(15),
    @JsonNames("Terrain")
    TERRAIN(16),

    @UnknownEntry
    UNKNOWN(9999);

    override fun getIntKey() = id
}
