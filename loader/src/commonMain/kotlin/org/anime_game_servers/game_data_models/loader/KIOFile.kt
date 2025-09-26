package org.anime_game_servers.game_data_models.loader

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.io.Sink
import kotlinx.io.Source
import kotlinx.io.buffered
import kotlinx.io.files.FileSystem
import kotlinx.io.files.Path
import kotlinx.io.files.SystemFileSystem
import kotlin.jvm.JvmOverloads

class KIOFile(val path: Path, val fileSystem: FileSystem = SystemFileSystem) : AGDMFile {

    @JvmOverloads
    constructor(path: String, fileSystem: FileSystem = SystemFileSystem) : this(Path(path), fileSystem)
    override suspend fun exists(): Boolean {
        return fileSystem.exists(path)
    }

    override suspend fun isFile(): Boolean {
        return fileSystem.metadataOrNull(path)?.isRegularFile ?: false
    }

    override suspend fun getBaseName(): String {
        return path.name
    }

    override suspend fun isDirectory(): Boolean {
        return fileSystem.metadataOrNull(path)?.isDirectory ?: false
    }

    override suspend fun getFile(targetPath: String): AGDMFile {
        return KIOFile(Path(this.path, targetPath), fileSystem)
    }

    override suspend fun listFiles(): List<AGDMFile> {
        return fileSystem.list(path).map { KIOFile(it, fileSystem) }
    }

    override suspend fun getSource(ioDispatcher: CoroutineDispatcher): Source {
        return fileSystem.source(path).buffered()
    }

    override suspend fun getSink(ioDispatcher: CoroutineDispatcher): Sink {
        return fileSystem.sink(path).buffered()
    }

    override fun close() {
        // nothing to do
    }
}