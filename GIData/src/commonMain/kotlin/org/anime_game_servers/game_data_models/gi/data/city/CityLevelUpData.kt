@file:OptIn(ExperimentalSerializationApi::class)

package org.anime_game_servers.game_data_models.gi.data.city

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.gi.data.quest.GainItem
import org.anime_game_servers.game_data_models.gi.helpers.getNonNull
import org.anime_game_servers.game_data_models.gi.helpers.getValueNonNull
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType
import org.anime_game_servers.game_data_models.loader.enums.EnumWrapper
import kotlin.jvm.JvmStatic

/**
 * This is used to control the city (Statue of the seven) level up system and rewards.
 */
@DataFile("ExcelBinOutput/CityLevelupConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/CityLevelUpData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class CityLevelUpData(
    val sceneId: Int = 3,
    val cityId: Int,
    val level: Int,
    val consumeItem: GainItem? = null,
    @JsonNames("rewardID")
    val rewardId: Int = UnsetInt,
    @JsonNames("actionVec")
    val actions: List<CityLevelUpAction>? = null,
) : IntKey {
    override fun getIntKey() = getKey(cityId, level)

    fun getActionsNonNull() = actions.getNonNull()

    /*
     * Defines
     */
    @Serializable
    data class CityLevelUpAction(
        @Serializable(with = WorldAreaActionContainerSerializer::class)
        val type: EnumWrapper<WorldAreaAction>? = null,
        @JsonNames("param1Vec")
        val param1: List<Int>? = null,
        @JsonNames("param2Vec")
        val param2: List<Int>? = null,
    ){
        fun getTypeNonNull() = type.getValueNonNull(WorldAreaActionMetadata)
        fun getParam1NonNull() = param1.getNonNull()
        fun getParam2NonNull() = param2.getNonNull()
    }

    companion object {
        @JvmStatic
        fun getKey(cityId: Int, level:Int) = (cityId shl 4) + level
    }

}
