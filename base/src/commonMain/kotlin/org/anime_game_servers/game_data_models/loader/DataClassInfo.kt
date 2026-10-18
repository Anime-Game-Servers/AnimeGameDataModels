package org.anime_game_servers.game_data_models.loader

import kotlinx.serialization.KSerializer
import kotlin.reflect.KClass

interface DataClassInfo<T> {
    val className: String
    val packageName: String
    val kClass: KClass<T &Any>
    val serializer: KSerializer<T>
    val fileInfos: List<DataFile>
}
