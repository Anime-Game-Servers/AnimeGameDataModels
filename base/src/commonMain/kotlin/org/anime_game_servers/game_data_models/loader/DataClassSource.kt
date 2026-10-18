package org.anime_game_servers.game_data_models.loader

interface DataClassSource {
    fun getDataClassInfo(): List<DataClassInfo<*>>
}
