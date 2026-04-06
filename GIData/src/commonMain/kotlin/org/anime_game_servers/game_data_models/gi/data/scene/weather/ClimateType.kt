package org.anime_game_servers.game_data_models.gi.data.scene.weather

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.helpers.enumValueOfOrDefault
import kotlin.jvm.JvmStatic

@Serializable
enum class ClimateType(val id: Int) : IntKey {
    CLIMATE_NONE(0),
    CLIMATE_SUNNY(1),
    CLIMATE_CLOUDY(2),
    CLIMATE_RAIN(3),
    CLIMATE_THUNDERSTORM(4),
    CLIMATE_SNOW(5),
    CLIMATE_MIST(6),
    CLIMATE_DESERT(7),
    CLIMATE_VOLCANO_OUTSIDE(8),

    /**
     * This is used when the type is unknown to the library, check the string version of the field to see what it contained
     */
    CLIMATE_UNKNOWN(9999);

    override fun getIntKey() = id

    fun getShortName() = this.name.let { name -> if(name.length > 8) name.substring(8).lowercase() else name }

    companion object {
        @JvmStatic
        fun getTypeByValue(value: Int): ClimateType? = entries.find { it.id == value }
        @JvmStatic
        fun getTypeByName(name: String): ClimateType = enumValueOfOrDefault(name, CLIMATE_UNKNOWN)
        @JvmStatic
        fun getTypeByShortName(name: String?): ClimateType = entries.find { it.getShortName() == name } ?: CLIMATE_UNKNOWN
    }
}