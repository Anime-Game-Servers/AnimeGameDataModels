package org.anime_game_servers.game_data_models.loader

import org.anime_game_servers.game_data_models.loader.stripping.StripConfig


/**
 * TODO add config for loading to allow patching/merging and prefer one source
 * TODO add handling for wildcards in file paths
 */
interface DataLoader {
    var stripConfig: StripConfig

    fun setParser(type: FileType, parser: DataParser)
    fun addFolderTypeSource(folderType: FolderType, source: AGDMFile)
    fun registerDataClassSource(source: DataClassSource)
    fun unregisterDataClassSource(source: DataClassSource)

    suspend fun <T> loadList(dataClassInfo: DataClassInfo<T>): List<T>?
    suspend fun <T, K> loadMap(dataClassInfo: DataClassInfo<T>): Map<K, T>?
    suspend fun <T> loadModel(dataClassInfo: DataClassInfo<T>): T?
}