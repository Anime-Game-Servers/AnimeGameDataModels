package org.anime_game_servers.game_data_models.loader


/**
 * Provider interface used for generating the auto registration classes used in the JVM
 */
interface DataClassSourceProvider {
    fun getDataClassSource(): List<DataClassSource>
}
