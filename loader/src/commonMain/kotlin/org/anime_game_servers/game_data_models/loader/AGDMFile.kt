package org.anime_game_servers.game_data_models.loader

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.io.Sink
import kotlinx.io.Source
import org.anime_game_servers.game_data_models.loader.DipatcherDefaults.defaultIoDispatcher

@OptIn(ExperimentalStdlibApi::class)
interface AGDMFile : AutoCloseable{
    suspend fun exists(): Boolean
    suspend fun isFile(): Boolean
    suspend fun getBaseName(): String
    suspend fun isDirectory(): Boolean
    suspend fun getFile(targetPath: String): AGDMFile
    suspend fun listFiles(): List<AGDMFile>
    suspend fun getSource(ioDispatcher: CoroutineDispatcher = defaultIoDispatcher): Source
    suspend fun getSink(ioDispatcher: CoroutineDispatcher = defaultIoDispatcher): Sink
}
